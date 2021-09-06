import java.util.Scanner;

public class MatrixMultiplication{

	public static int[][] inputMatrix(int n1, int m1, Scanner sc){
	    int[][] matrix = new int[n1][m1];
	    for(int i=0; i<n1; i++){
	        for(int j=0; j<m1; j++){
	            matrix[i][j] = sc.nextInt();
	        }
	    }
	    return matrix;
	}

	public static void printMatrix(int[][] matrix){
	    for(int i=0; i<matrix.length; i++){
	        for(int j=0; j<matrix[0].length; j++){
	            System.out.print(matrix[i][j] + " ");
	        }
	        System.out.println();
	    }
	}

	public static int[][] multiplyMatrix(int[][] m1, int[][] m2){
	    int r1 = m1.length;
	    int c1 = m1[0].length;
	    int r2 = m2.length;
	    int c2 = m2[0].length;
	    
	    if(c1 != r2){
	        errorFlag = true;
	        return new int[0][0];
	    }
	    int[][] result = new int[r1][c2];
	    
	    for(int i=0; i<r1; i++){
	        for(int j=0; j<c2; j++){
	            int sum = 0;
	            for(int k=0; k<c1; k++){
	                sum += m1[i][k] * m2[k][j]; 
	            }
	            result[i][j] = sum;
	        }
	    }
	    return result;
	}

	static boolean errorFlag = false;

	public static void main(String[] args) throws Exception {
	    // write your code here
	    Scanner sc = new Scanner(System.in);
	    int n1 = sc.nextInt();
	    int m1 = sc.nextInt();
	    int[][] a1 = inputMatrix(n1, m1, sc);
	    int n2 = sc.nextInt();
	    int m2 = sc.nextInt();
	    int[][] a2 = inputMatrix(n2, m2, sc);
	    int[][] result = multiplyMatrix(a1, a2);
	    if(!errorFlag){
	        printMatrix(result);
	    } else {
	        System.out.println("Invalid input");
	    }
	 }

}