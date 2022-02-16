class L11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxWater = Integer.MIN_VALUE;
        while(left < right){
            maxWater = Math.max(maxWater, (right - left) * Math.min(height[left], height[right]));
            if(height[left] <= height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}