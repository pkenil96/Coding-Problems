import java.io.*;
import java.util.*;

public class Main {
    
    public static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }


    public static void rotateArray(int[] array, int k){
        int n = array.length;
        int startIndex, endIndex;
        
        // we first reverse first n-k elements
        startIndex = 0;
        endIndex = n-k-1;
        while(startIndex <= endIndex){
            swap(array, startIndex++, endIndex--);
        }

        // now we reverse last k elements
        startIndex = n-k;
        endIndex = n-1;
        while(startIndex <= endIndex){
            swap(array, startIndex++, endIndex--);
        }

        // now we reverse the entire array
        startIndex = 0;
        endIndex = n-1;
        while(startIndex <= endIndex){
            swap(array, startIndex++, endIndex--);
        }                
        return;
    }

    public static int[] fill1DArrayFromShell(int[][] matrix, int n){
        int minRow = n - 1;
        int minCol = n - 1;
        int maxRow = matrix.length - n;
        int maxCol = matrix[0].length - n;

        int arraySize = 2 * (maxRow - minRow + 1) +  2 * (maxCol - minCol + 1) - 4;
        int[] array = new int[arraySize];
        int index = 0;
        
        for(int i=minRow, j=minCol; i<=maxRow; i++){
            array[index++] = matrix[i][j];
        }
        
        for(int i=maxRow, j=minCol+1; j<=maxCol; j--){
            array[index++] = matrix[i][j];
        }

        // right wall
        for(int i=maxRow-1, j=minCol; i>=minRow; i--){
            array[index++] = matrix[i][j];
        }        

        return array;
    }

    public static void fillShellFrom1DArray(int[][] matrix, int n, int[] array){
        int minRow = n - 1;
        int minCol = n - 1;
        int maxRow = matrix.length - n;
        int maxCol = matrix[0].length - n;

        int index = 0;
        
        // top wall
        for(int i=minRow, j=minCol; j<maxCol; j++){
            matrix[i][j] = array[index++];
        }
        
        // right wall
        for(int i=minRow+1, j=maxCol; i<maxRow; i++){
            matrix[i][j] = array[index++];
        }

        // right wall
        for(int i=maxRow, j=maxCol-1; j>=minCol; j--){
            matrix[i][j] = array[index++];
        }

        // right wall
        for(int i=maxRow-1, j=minCol; i>=minRow; i--){
            matrix[i][j] = array[index++];
        }        
    }

    public static int[][] ringRotate(int[][] matrix, int ringNumber, int numberOfRotations){
        int[] oneD = fill1DArrayFromShell(matrix, ringNumber);
        rotateArray(oneD, numberOfRotations);
        fillShellFrom1DArray(matrix, ringNumber, oneD);
        return matrix;
    }
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] matrix = inputMatrix(r, c, sc);
        int ringNumber = sc.nextInt();
        int numberOfRotations = sc.nextInt();
        display(ringRotate(matrix, ringNumber, numberOfRotations));
    }
    
    public static int[][] inputMatrix(int n1, int m1, Scanner sc) {
        int[][] matrix = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
          for (int j = 0; j < m1; j++) {
            matrix[i][j] = sc.nextInt();
          }
        }
        return matrix;
    }
    
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}