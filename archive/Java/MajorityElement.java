package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        HashMap <Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int item = nums[i];
            if(hmap.containsKey(item)){
                hmap.put(item, hmap.get(item) + 1);
            } else {
                hmap.put(item, 1);
            }
        }
        
        Iterator itr = hmap.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry me = (Map.Entry)itr.next(); 
            int value = (int)me.getValue();
            if(value > nums.length/2)
                return (int)me.getKey();
        }
        return -1;
    }
}