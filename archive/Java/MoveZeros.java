package leetcode;

class MoveZeros{

	public static void moveZerosUtil(int [] nums){
		if(nums == null || nums.length == 0)
			return;
		int index = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i] != 0){
				nums[index++] = nums[i];
			}
		}
		for(int i=index; i<nums.length; i++){
			nums[i] = 0;
		}
		
	}

	public static void print(int [] nums){
		if(nums == null || nums.length == 0)
			return;
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int [] nums = {0, 0, 1, 0};
		print(nums);
		moveZerosUtil(nums);
		print(nums);
	}
}