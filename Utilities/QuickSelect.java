public class QuickSelect {
    
    private static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    /**
     * 0 to left-1: elements smaller than pivot
     * left to right-1: elements greater than pivot
     * right to n: unexplored elements
     * returns index of the pivot element
     */
    private static int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int left = low, right = low;
        while(right <= high){
            if(nums[right] <= pivot){
                swap(nums, left++, right++);
            } else {
                right++;
            } 
        }
        return left-1;
    }

    private static int quickSelect(int[] nums, int k, int low, int high){
        if(low < high){
            int pivotIndex = partition(nums, low, high);
            if(pivotIndex < k){
                return quickSelect(nums, k, pivotIndex+1, high);
            } else if(pivotIndex > k){
                return quickSelect(nums, k, low, pivotIndex-1);
            } else {
                return nums[k];
            }
        }
        return nums[k];
    }

    public static int quickSelect(int[] nums, int k){
        int kthLargestIndex = nums.length - k;
        return quickSelect(nums, kthLargestIndex, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 1, 3, 7, 2, 6, 4};
        int k = 5;
        System.out.println(k + "th smallest: " + quickSelect(nums, k, 0, nums.length-1));
    }
}
