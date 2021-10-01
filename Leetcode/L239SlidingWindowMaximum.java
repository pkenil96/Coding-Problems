class L239SlidingWindowMaximum {
    
    public static int[] solution0(int[] nums, int k){
        // TLE: O(n*k)
        int n = nums.length, index=0;
        int[] result = new int[n-k+1];
        for(int i=0; i<=n-k; i++){
            int max = Integer.MIN_VALUE;
            for(int j=i; j<i+k; j++){
                max = Math.max(max, nums[j]);
            }
            result[index++]=max;
        }
        return result;
    }
    
    // solution using max heap
    public static int[] solution1(int[] nums, int k){
        int n = nums.length;
        int[] result = new int[n-k+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        // initializing the heap with k elements
        for(int i=0; i<k; i++){
            pq.add(new int[]{nums[i], i});
        }
        int index = 0;
        result[index++] = pq.peek()[0];
        
        for(int i=1; i<=n-k; i++){
            pq.add(new int[]{nums[i+k-1], i+k-1});
            int item = pq.peek()[0];
            int idx = pq.peek()[1];
            
            while(pq.peek()[1] < i){
                pq.poll();    
            }
            result[index++] = pq.peek()[0];
        }
        return result;
    }
    
    
    // solution using deque
    public static int[] solution2(int[] nums, int k){
        
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        return solution0(nums, k);
        //return solution1(nums, k);
        //return solution2(nums, k);
    }
}