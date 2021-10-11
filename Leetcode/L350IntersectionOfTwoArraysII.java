class L350IntersectionOfTwoArraysII {
    
    public int[] method0(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                int freq = map.get(num);
                if(freq == 0){
                    continue;
                }
                list.add(num);
                map.put(num, freq-1);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    public int[] intersect(int[] nums1, int[] nums2) {
        return method0(nums1, nums2);
    }
}