class L695MaxAreaOfIsland {
    
    static int local;
    static int global;
    
    public static void dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){
            return;
        }
        grid[i][j] = 2;
        local++;
        global = Math.max(global, local);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i-1, j);
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        global=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    local=0;
                    dfs(grid, i, j);
                }
            }
        }
        return global;
    }
}