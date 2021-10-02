class L1086HighFive {
    
    int topFiveAverage(ArrayList<Integer> marks){
        Collections.sort(marks);
        int sum=0, n=marks.size();
        for(int i=n-1; i>=n-5; i--){
            sum+=marks.get(i);
        }
        return sum/5;
    }
    
    public int[][] highFive(int[][] items) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<items.length; i++){
            int key = items[i][0];
            int val = items[i][1];
            if(map.containsKey(key)){
                ArrayList<Integer> temp = map.get(key);
                temp.add(val);
                map.put(key, temp);
            } else {
                ArrayList<Integer>temp = new ArrayList<>();
                temp.add(val);
                map.put(key, temp);
            }
        }
        
        int[][] res = new int[map.size()][2];
        int index = 0;
        for(Map.Entry<Integer,ArrayList<Integer>> pair: map.entrySet()){
            int key = pair.getKey();
            int val = topFiveAverage(pair.getValue());
            res[index][0] = key;
            res[index][1] = val;
            index++;
        }
        return res;
    }
}