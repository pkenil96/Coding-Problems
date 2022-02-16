class L62UniquePaths {
    public int uniquePaths(int srcRow, int srcCol, int desRow, int desCol, Integer[][] memo){
        if(memo[srcRow][srcCol] != null){
            return memo[srcRow][srcCol];
        }
        
        if(srcRow == desRow && srcCol == desCol){
            return 1;
        }
        if(srcRow > desRow || srcCol > desCol){
            return 0;
        }
        else {
            int uniquePathsByMovingRight = uniquePaths(srcRow, srcCol+1, desRow, desCol, memo);
            int uniquePathsByMovingDown = uniquePaths(srcRow+1, srcCol, desRow, desCol, memo);
            memo[srcRow][srcCol] = uniquePathsByMovingRight + uniquePathsByMovingDown;
            return memo[srcRow][srcCol];
        }
        
    }
    
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m+1][n+1];
        return uniquePaths(0, 0, m-1, n-1, memo);
    }
}