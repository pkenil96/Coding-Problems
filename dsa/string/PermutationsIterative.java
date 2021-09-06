import java.io.*;
import java.util.*;

public class PermutationsIterative {
    
    public static int fact(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n * fact(n-1);
    }
    
	public static void solution(String s1){
		// write your code here
		int n = s1.length();
		int f = fact(n);
		for(int i=0; i<f; i++){
		    int temp = i;
		    StringBuilder str = new StringBuilder(s1);
		    StringBuilder s = new StringBuilder();
		    for(int div = n; div>=1; div--){
		        int q = temp / div;
		        int r = temp % div;
		        s.append(str.charAt(r));
		        str.deleteCharAt(r);
		        temp = q;
		    }
		    System.out.println(s);
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}