class L56MergeIntervals {
    
    public static int[][] method1(int[][] intervals){
        int startIndex = 0;
        int endIndex = 1;
        // stack will store all the merged intervals at the end
        Stack<int[]> stack = new Stack<>();
        // sorting the stack by start time of each interval
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        
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