import java.util.Scanner;

public class DP03ClimbStairsWithVariableJumps{
	
	public static int variableJumpsBruteForce(int index, int[] jumps){
		if(index == jumps.length){
			return 1;
		}

		if(index > jumps.length){
			return 0;
		}

		int ways = 0;
		for(int i=1; i<=jumps[index]; i++){
			ways += variableJumpsBruteForce(i + index, jumps);
		}
		return ways;
	}

	public static int variableJumpsTopDown(int index, int[] jumps, Integer[] memo){
		if(index == jumps.length){
			return 1;
		}
		if(index > jumps.length){
			return 0;
		}
		if(memo[index] != null){
			return memo[index];
		} else {
			int ways = 0;
			for(int i=1; i<=jumps[index]; i++){
				ways += variableJumpsTopDown(index + i, jumps, memo);
			}
			memo[index] = ways;
			return memo[index];
		}
	}

	public static int variableJumpsBottomUp(int[] jumps){
		int n = jumps.length;
		int[] dp = new int[n+1];
		dp[n] = 1;
		for(int i=n-1; i>=0; i--){
			for(int j=1; j<=jumps[i] && i+j<=n; j++){
				dp[i] += dp[i+j];
			}
		}
		return dp[0];
	}	

	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] jumps = new int[n];
        for(int i=0; i<n; i++){
            jumps[i] = sc.nextInt();
        }
        
        int startIndex = 0;

        System.out.println(variableJumpsBruteForce(startIndex, jumps));
        
        Integer[] memo = new Integer[n+1];
        System.out.println(variableJumpsBottomUp(startIndex, jumps, memo));

        System.out.println(variableJumpsBottomUp(jumps));
    }
}