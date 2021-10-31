class L347TopKFrequentElements {
    
    // using hashmap - slower (sorting takes nlogn time)
    public int[] method0(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        // sorting the hashmap by value
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                return (e1.getValue() == e2.getValue()) ? e1.getKey().compareTo(e2.getKey()) : e2.getValue() - e1.getValue();
            }
        });
        HashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        // picking up the top k elements from the hashmap
        int index = 0;
        int[] result = new int[k];
        for(Map.Entry<Integer, Integer> entry: sortedMap.entrySet()){
            result[index++] = entry.getKey();
            if(index == k){
                break;
            }
            
        }
        return result;
    }
    
    // using min heap - efficient; runs in nlogk time
    public int[] method1(int[] nums, int k){
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        //PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
            //public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
            //    return e1.getValue() - e2.getValue();
            //}
        //});
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        for(int i=k-1; i>=0; i--){
            result[i] = pq.poll().getKey();
        }
        
        return result;
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        //return method0(nums, k);
        return method1(nums, k);
    }
}