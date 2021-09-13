import java.io.*;
import java.util.*;

public class RotateImage {

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static int[][] inputMatrix(int n, Scanner sc) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            matrix[i][j] = sc.nextInt();
          }
        }
        return matrix;
    }


    public static int[][] transpose(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }


    public static int[][] reverseRows(int[][] matrix){
        int lastRow = matrix.length-1;
        int lastCol = matrix[0].length-1;
        int currRow=0;
        while(currRow <= lastRow){
            for(int i=0, j=lastCol; i<=lastCol/2; i++, j--){
                int temp = matrix[currRow][i];
                matrix[currRow][i] = matrix[currRow][j];
                matrix[currRow][j] = temp;
            }
            currRow++;
        }
        return matrix;
    }


    public static int[][] rotateImage(int[][] matrix){
        // we first find the transpose of the matrix
        // and then reverse each row to get the result
        int[][] res = reverseRows(transpose(matrix));
        return res;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = inputMatrix(n, sc);
        int[][] rotated = rotateImage(matrix);
        display(rotated);
    }

}