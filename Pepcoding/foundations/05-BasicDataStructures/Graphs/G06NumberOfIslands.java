import java.io.*;
import java.util.*;

public class G06NumberOfIslands {
    
    public static void dfs(int[][] matrix, int x, int y){
        if(x<0 || x>=matrix.length || y<0 || y>=matrix[0].length || matrix[x][y] != 0){
            return;
        }
        matrix[x][y] = 2;
        dfs(matrix, x+1, y);
        dfs(matrix, x, y+1);
        dfs(matrix, x, y-1);
        dfs(matrix, x-1, y);
    }
    
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
      int count=0;
      for(int i=0; i<m; i++){
          for(int j=0; j<n; j++){
              if(arr[i][j] == 0){
                  dfs(arr, i, j);
                  count++;
              }
          }
      }
      System.out.println(count);
   }

}