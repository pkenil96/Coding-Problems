import java.util.Scanner;

// climbing stairs with either 1, 2 or 3 steps
public class DP2ClimbStairs{
	
	public static int climbStairsBruteForce(int n){
		if(n < 0){
			return 0;
		}
		if(n == 0 || n == 1){
			return 1;
		}
		return climbStairsBruteForce(n-1) + climbStairsBruteForce(n-2) + climbStairsBruteForce(n-3);
	}

	public static int climbStairsTopDown(int n, Integer[] memo){
        if(n < 0){
            return 0;
        }
        if(n == 0 || n == 1){
            return 1;
        }
        if(memo[n] != null){
            return memo[n];
        } else {
            memo[n] = climbStairsTopDown(n-1, memo) + climbStairsTopDown(n-2, memo) + climbStairsTopDown(n-3, memo);
            return memo[n];
        }
    }
    
    public static int climbStairsBottomUp(int n){
        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++){
            if(i == 0 || i == 1){
                dp[i] = 1;
            } else if(i == 2){
                dp[i] = 2;
            } else {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] memo = new Integer[n+1];
        //System.out.println(climbStairsTopDown(n, memo));
        System.out.println(climbStairsBottomUp(n));
    
    }
}