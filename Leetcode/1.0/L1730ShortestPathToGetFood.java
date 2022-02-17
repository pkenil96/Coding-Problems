import java.util.*;

class Pair1730{
    int x;
    int y;
    Pair1730(int x1, int y1){
        x=x1;
        y=y1;
    }
}

class L1730ShortestPathToGetFood {
    
    public int bfs(int src, int col, char[][] grid, boolean[][] visited){
        int ans=0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair1730> q = new LinkedList<>();
        q.add(new Pair1730(src, col));
        visited[src][col] = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int p=0; p<size; p++){
                int[] dr = {1, -1, 0, 0};
                int[] dc = {0, 0, 1, -1};
                Pair1730 pair = q.poll();
                for(int i=0; i<4; i++){
                    int newX = pair.x + dr[i];
                    int newY = pair.y + dc[i];
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 'X' || grid[newX][newY] == '*' || visited[newX][newY] == true){
                        continue;
                    }
                    if(grid[newX][newY] == '#'){
                        return ans+1;
                    }
                    visited[newX][newY]=true;    
                    q.add(new Pair1730(newX, newY));
                }
            }
            ans++;
        }
        return -1;
    }
    
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '*'){
                    return bfs(i, j, grid, visited);
                }
            }
        }
        return -1;
    }
}