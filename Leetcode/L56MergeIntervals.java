import java.util.*;

public class L56MergeIntervals {
    
    public static int[][] method2(int[][] intervals){
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int startIndex = 0, endIndex = 1;
        int[] temp = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[startIndex] <= temp[endIndex]){
                temp[endIndex] = Math.max(curr[endIndex], temp[endIndex]);
            } else {
                result.add(temp);
                temp = curr;
            }
        }
        return result.toArray(new int[result.size()][]);
        /*int[][] ans = new int[result.size()][2];
        for(int i=0; i<result.size(); i++){
            ans[i] = result.get(i);
        }
        return ans;
        */
    }
    
    public static int[][] method1(int[][] intervals){
        int startIndex = 0;
        int endIndex = 1;
        // stack will store all the merged intervals at the end
        Stack<int[]> stack = new Stack<>();
        // sorting the stack by start time of each interval
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        stack.push(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int[] top = stack.peek();
            int[] curr = intervals[i];
            if(top[endIndex] >= curr[startIndex]){
                top[endIndex] = Math.max(curr[endIndex], top[endIndex]);
                stack.pop();
                stack.push(top);
            } else {
                stack.push(curr);
            }
        }
        
        int[][] res = new int[stack.size()][2];
        for(int i=stack.size()-1; i>=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
    
    public int[][] merge(int[][] intervals) {
        return method1(intervals);
    }
}