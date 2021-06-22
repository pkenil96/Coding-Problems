/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target. You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.HashMap;

public class TwoSum{
    public static int[] twoSumBruteForce(int [] nums, int target){
        // the brute force approach would be two check the sum of
        // each pair and compare it with the target
        
        if(nums.length == 0 || nums == null) return null;
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    /*
                    error: array creation with both dimension expression and initialization is illegal
                    return new int[2]{i, j};
                    */
                    // return new int[2]{i, j}; --> commented after first compilation error
                    return new int[]{i, j};
                }
            }
        }
        return null;       
    }
    
    public static int[] twoSumOptimized(int [] nums, int target){
        // Using the hashset to track complements
        /* 
            another approach can be scanning the array and hashing the complements of the
            current element. Complement = target - current element. For each element, we check
            if the set contains the complement or not. If yes,we return true!
            However, this method would only return if the tuple exists or not that adds to the
            target sum, hence this method cannot be employed here
        */
        
        // Another approach
        /*
            The problem can be solved if we have a mapping between the element and its index 
            since  index is important to us. For example, 
            0 -> 2
            1 -> 7
            2 -> 11
            3 -> 5
            4 -> 4
            While traversing the array, we check for the complement of the array element. However,
            here we need the reverse mapping as well to achieve the result.
            
            Instead if we could invert the mapping, the job would be done.
            2 -> 0
            7 -> 1
            2 -> 11
            3 -> 5
            4 -> 4
            Now the complement existence can be checked in O(1) time and its index can also be found
            out in O(1) time, at the expense of O(n) extra space.
        */
        if(nums == null || nums.length == 0) return null;
        
        HashMap <Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hmap.containsKey(target - nums[i])){
                return new int[]{i, hmap.get(target - nums[i])};
            } else {
                hmap.put(nums[i], i);
            }
        }        
        return null;       
    }

    public static void main(String [] args){
        int [] nums = {2, 7, 11, 5, 4};
        int target = 6;
        int [] solutionBF = twoSumBruteForce(nums, target);
        if(solutionBF == null){
            System.out.println("No solution");
        } else {
            System.out.println("[" + solutionBF[0] + "," + solutionBF[1] + "]");
        }
        
        int [] solutionOP = twoSumBruteForce(nums, target);
        if(solutionOP == null){
            System.out.println("No solution");
        } else {
            System.out.println("[" + solutionOP[0] + "," + solutionOP[1] + "]");
        }
        
    }
}
