import java.util.Scanner;
import java.util.ArrayList;

public class GetStairPath{
	public static void backtrack(int n, String temp, ArrayList<String> steps){
        if(n == 0){
            steps.add(temp);
            return;
        }
        
        if(n < 0){
            return;
        }
        
        // climbing 1 stair
        backtrack(n-1, temp+"1", steps);
        // climbing 2 stairs
        backtrack(n-2, temp+"2", steps);
        // climbin 3 stairs
        backtrack(n-3, temp+"3", steps);
    }
    
    public static ArrayList<String> getStairPaths(int n) {
        ArrayList<String> steps = new ArrayList<>();
        backtrack(n, "", steps);
        return steps;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getStairPaths(n));
    }
}