package io.github.pkenil96.backtracking;

public class SubsetSum {
	public static boolean backtrack(int index, int[] array, int sum, Boolean[][] memo) {
		if (sum == 0) {
			return true;
		}
		if (index >= array.length || sum < 0) {
			return false;
		}
		if (memo[index][sum] != null) {
			return memo[index][sum];
		} else {
			boolean include = backtrack(index + 1, array, sum - array[index], memo);
			boolean exclude = backtrack(index + 1, array, sum, memo);
			memo[index][sum] = include || exclude;
			return memo[index][sum];
		}
	}

	public static Boolean isSubsetSum(int N, int arr[], int sum) {
		Boolean[][] memo = new Boolean[N + 1][sum + 1];
		return backtrack(0, arr, sum, memo);
	}
}
