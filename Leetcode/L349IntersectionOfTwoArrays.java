import java.util.*;

class L349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        // set1 will always be greater than set2
        for(int num: nums1){
            set1.add(num);
        }   
        for(int num: nums2){
            set2.add(num);
        }
        Iterator<Integer> itr = set1.iterator();
        List<Integer> list = new ArrayList<>();
        while(itr.hasNext()){
            int item = itr.next();
            if(set2.contains(item)){
                list.add(item);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }    
}