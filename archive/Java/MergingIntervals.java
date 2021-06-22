package leetcode;

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

import java.util.Arrays;
import java.util.Comparator;

class MergingIntervals{

    public int[][] merge(int [][] intervals){
        if(intervals.length == 0 || intervals == null)
            return null;
        //first we sort the intervals in increasing order based on the starting time
        Integer [][] intervalsObj = ArrayUtils.toObject(intervals);
        Arrays.sort(intervalsObj, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                
            }
        });
    }    
    
    public static void main(String [] args){
        int [][] intervals = {{1,3}, {2,6}, {8,10}, {15,18};
        int [][] mergedIntervals = merge(intervals);        
    }
}
