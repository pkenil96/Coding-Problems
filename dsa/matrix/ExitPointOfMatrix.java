import java.io.*;
import java.util.*;

public class ExitPointOfMatrix {

    public static int[][] inputMatrix(int n1, int m1, Scanner sc) {
        int[][] matrix = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
          for (int j = 0; j < m1; j++) {
            matrix[i][j] = sc.nextInt();
          }
        }
        return matrix;
    }


    public static int[] getExitPoints(int[][] matrix){
        int i=0, j=0;
        int m=matrix.length, n=matrix[0].length;
        char direction='e';
        while(true){
            if( (direction=='e' && matrix[i][j] == 0 && j+1==n) || 
                (direction=='n' && matrix[i][j] == 0 && i-1==-1) || 
                (direction=='s' && matrix[i][j] == 0 && i+1==m) || 
                (direction=='w' && matrix[i][j] == 0 && j-1==-1)
            ) {
                int[] res = new int[2];
                res[0] = i;
                res[1] = j;
                return res;
            }
            if(matrix[i][j]==0){ //keep moving in the same direction, move one step ahead
                if(direction=='e'){
                    j++;
                } else if(direction == 's'){
                    i++;
                } else if(direction == 'w'){
                    j--;
                } else {
                    i--;
                }
            } else { //turn right by 90 degrees
                if(direction=='e'){
                    direction = 's';
                    i++;
                } else if(direction == 's'){
                    direction = 'w';
                    j--;
                } else if(direction == 'w'){
                    direction = 'n';
                    i--;
                } else {
                    direction = 'e';
                    j++;
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] matrix = inputMatrix(r, c, sc);
        int[] ans = getExitPoints(matrix);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

}