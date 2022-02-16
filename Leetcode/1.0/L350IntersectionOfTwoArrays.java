import java.util.*;

class L350IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2){
        // the range of the numbers in both the arrays is given
        // so we can take advantage of that fact and avoid using
        // hashmap. Use array of size instead for faster lookup
        List<Integer> result = new ArrayList<>();
        int[] map = new int[1001];
        for(int num: nums1){
            map[num]+=1;
            //map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num: nums2){
            //if(map.containsKey(num)){
              if(map[num] > 0){
                result.add(num);
                map[num]-=1;   
            }
        }
        
        int[] ans = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            ans[i] = result.get(i);  
        }
        return ans;
    }
    
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num: nums2){
            if(map.containsKey(num)){
                int val = map.get(num);
                if(val > 0){
                    result.add(num);
                    map.put(num, val-1);   
                }
            }
        }
        
        int[] ans = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            ans[i] = result.get(i);  
        }
        return ans;
    }
}