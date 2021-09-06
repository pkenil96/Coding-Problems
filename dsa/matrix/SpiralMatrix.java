import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static int[][] inputMatrix(int n1, int m1, Scanner sc) {
        int[][] matrix = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
          for (int j = 0; j < m1; j++) {
            matrix[i][j] = sc.nextInt();
          }
        }
        return matrix;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = matrix.length-1;
        int maxCol = matrix[0].length-1;
        int total = (maxRow+1)*(maxCol+1);
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(ans.size() < total){
            for(int i=minRow, j=minCol; j<=maxCol && ans.size() < total; j++){
                ans.add(matrix[i][j]);
            }
            minRow++;
            for(int i=minRow, j=maxCol; i<=maxRow && ans.size() < total; i++){
                ans.add(matrix[i][j]);
            }
            maxCol--;
            for(int i=maxRow, j=maxCol; j>=minCol && ans.size() < total; j--){
                ans.add(matrix[i][j]);
            }
            maxRow--;
            for(int i=maxRow, j=minCol; i>=minRow && ans.size() < total; i--){
                ans.add(matrix[i][j]);
            }
            minCol++;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] matrix = inputMatrix(r, c, sc);
        ArrayList<Integer> res = spiralOrder(matrix);
        for(int x: res){
            System.out.println(x);
        }
  }

}