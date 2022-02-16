import java.util.*;

class L525ContiguousArray {
    public int findMaxLength(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            nums[i] = (nums[i] == 0)?-1:1;
            sum += nums[i];
            if(map.containsKey(sum)){
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}