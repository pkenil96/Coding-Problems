class L64MinimumPathSum {
    
    static int minCost;
    
    static class Cost{
        int val;
        Cost(int val){
            this.val = val;
        }
    }
    
    public static void dfs(int[][] matrix, int x, int y, Cost cost){
        if(x == matrix.length-1 && y == matrix[0].length - 1){
            minCost = Math.min(minCost, cost.val + matrix[x][y]);
            return;
        }
        
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length){
            return;
        }
        
        Cost newCost = new Cost(cost.val + matrix[x][y]);
        dfs(matrix, x+1, y, newCost);
        dfs(matrix, x, y+1, newCost);
    }
    
    public static int dfsMemo(int[][] matrix, int x, int y, Integer[][] memo){
        if(x == matrix.length-1 && y == matrix[0].length - 1){
            return matrix[x][y];
        }
        
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length){
            return 99999;
        }
        
        if(memo[x][y] != null){
            return memo[x][y];
        } else {
            int right = matrix[x][y] + dfsMemo(matrix, x+1, y, memo);
            int left = matrix[x][y] + dfsMemo(matrix, x, y+1, memo);
            memo[x][y] = Math.min(left, right);
            return memo[x][y];
        }
    }
    
    public static int bruteForce(int[][] grid){
		// exhaustive search - traveling all the paths and computing the cost
		dfs(grid, 0, 0, new Cost(0));
        return minCost;
	}

	public static int topDown(int[][] grid){
        Integer[][] memo = new Integer[grid.length][grid[0].length];
        return dfsMemo(grid, 0, 0, memo);
    }

	public static int bottomUp(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        
        int row, col;
        
        // the cost of reaching the last cell from the last cell is the cost of the cell itself
        dp[m-1][n-1] = grid[m-1][n-1];
        
        // first we fill the rightmost column as it will act as base case for our problem
        col = n-1;
        for(row=m-2; row>=0; row--){
            dp[row][col] = grid[row][col] + dp[row+1][col]; 
        }
        
        
        // then we fill the downmost row as it will act as base case for our problem
        row = m-1;
        for(col=n-2; col>=0; col--){
            dp[row][col] = grid[row][col] + dp[row][col+1]; 
        }
        
        for(row=m-2; row>=0; row--){
            for(col=n-2; col>=0; col--){
                dp[row][col] = grid[row][col] + Math.min(dp[row+1][col], dp[row][col+1]);
            }
        }
        
        return dp[0][0];
	}
    
    public int minPathSum(int[][] grid) {
        //minCost = Integer.MAX_VALUE;
        //return bruteForce(grid);
        //return topDown(grid);
        return bottomUp(grid);
    }
}