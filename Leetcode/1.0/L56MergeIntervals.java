import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class L56MergeIntervals {
    
    static int start = 0;
    static int end = 1;
    
    public int[][] optimized(int[][] intervals){
        if(intervals.length == 1){
            return intervals;
        }
        
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> result = new ArrayList<>();
        int[] curr = intervals[0];
        result.add(curr);
        
        for(int[] interval: intervals){
            if(curr[end] >= interval[start]){
                curr[end] = Math.max(curr[end], interval[end]);
            } else {
                curr = interval;
                result.add(curr);
            }
        }
        
        return result.toArray(new int[result.size()][2]);
    }
    
    public int[][] withoutUsingStack(int[][] intervals){
        if(intervals.length == 1){
            return intervals;
        }
        
        int index = 0;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        while(index < intervals.length){
            int[] curr = intervals[index];
            index++;
            while(index < intervals.length && curr[end] >= intervals[index][start]){
                curr[start] = Math.min(curr[start], intervals[index][start]);
                curr[end] = Math.max(curr[end], intervals[index][end]);
                index++;
            }
            list.add(curr);
        }
        return list.toArray(new int[list.size()][2]);
    }
    
    public int[][] usingStack(int[][] intervals){
        if(intervals.length == 1){
            return intervals;
        }
        
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        for(int[] interval: intervals){
            if(stack.isEmpty()){
                stack.push(interval);
            } else {
                int[] top = stack.peek();
                if(top[end] >= interval[start]){
                    stack.pop();
                    int[] temp = new int[]{ Math.min(top[start], interval[start]), Math.max(top[end], interval[end])}; 
                    stack.push(temp);
                } else {
                    stack.push(interval);
                }
            }
        }
        int index = stack.size()-1;
        int[][] mergedIntervals = new int[stack.size()][2];
        while(!stack.isEmpty()){
            mergedIntervals[index--] = stack.pop();
        }
        return mergedIntervals;
    }
    
    public int[][] merge(int[][] intervals) {
        //return usingStack(intervals);   
        //return withoutUsingStack(intervals);
        return optimized(intervals);
    }
}