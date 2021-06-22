import java.util.Scanner;
import java.util.HashSet;

// O(n^2) approach

public class Vestigium{ //need to be renamed as Solution while submitting

    public static int trace(int [][] matrix, int N){
        int trace = 0;
        for(int i=0; i<N; i++)
            trace += matrix[i][i];
        return trace;
    }

    public static int[] vestigiumUtil(int [][] matrix){
        int N = matrix.length;
        int [] solution = new int[3];
        solution[0] = trace(matrix, N);
        
        int rows = 0, cols = 0;
        HashSet <Integer> set = new HashSet<>();
        
        for(int i=0; i<N; i++){
            set.clear();
            for(int j=0; j<N; j++){
                if(set.contains(matrix[i][j])){
                    rows++;
                    break;
                }
                else
                    set.add(matrix[i][j]);
            }
        }
        
        for(int i=0; i<N; i++){
            set.clear();
            for(int j=0; j<N; j++){
                if(set.contains(matrix[j][i])){
                    cols++;
                    break;
                } else 
                    set.add(matrix[j][i]);
            }
        }
        
        solution[1] = rows;
        solution[2] = cols;
        return solution;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int testCases = 0;
        if(sc.hasNext())
            testCases = sc.nextInt();
        while(testCases > 0){
            int N = sc.nextInt();
            int [][] matrix = new int[N][N];
            
            for(int i=0; i<N; i++)
                for(int j=0; j<N; j++)
                    matrix[i][j] = sc.nextInt();
            
            int [] result = vestigiumUtil(matrix);
            //result[0] --> trace of the matrix
            //result[1] --> no. of rows containing duplicates
            //result[2] --> no. of columns containing the duplicates
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
            testCases--;
        }
    }
}
