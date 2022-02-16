class L42TrappingRainwater {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        
        maxLeft[0] = height[0];
        maxRight[n-1] = height[n-1];
        
        for(int i=1; i<n; i++){
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }
        
        int totalArea = 0;
        for(int i=0; i<n; i++){
            totalArea += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return totalArea;
    }
}