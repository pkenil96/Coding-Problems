import java.util.*;

public class DP07TargetSumSubsets{
	
	public static boolean bruteForce(int[] nums, int target, int index){
		if(target == 0){
			return true;
		}
		if(target < 0 || index >= nums.length){
			return false;
		}
		boolean include = bruteForce(nums, target - nums[index], index+1);
		boolean exclude = bruteForce(nums, target, index+1);
		return include || exclude;
	}

	public static boolean topDown(int[] nums, int target, int index, Boolean[][] memo){
		if(target == 0){
			return true;
		}
		if(target < 0 || index >= nums.length){
			return false;
		}
		if(memo[index] != null){
			return memo[index];
		} else {
			boolean include = bruteForce(nums, target - nums[index], index+1);
			boolean exclude = bruteForce(nums, target, index+1);
			memo[index] = include || exclude;
			return memo[index];
		}
	}

	public static boolean bottomUp(int[] nums, int target){
		boolean[][] dp = new boolean[nums.length+1][target+1];
		for(int i=0; i<=target; i++){
			dp[0][i] = false;
		}
		for(int i=0; i<=nums.length; i++){
			dp[i][0] = true;
		}
		for(int i=1; i<=target; i++){
			for(int j=1; j<=nums.length; i++){
				dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j];
			}
		}
		return dp[nums.length][target];
	}

	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int startIndex = 0;
        System.out.println(bruteForce(nums, target, startIndex));
        System.out.println(topDown(nums, target, startIndex));
        System.out.println(bottomUp(nums, target));
    }
}