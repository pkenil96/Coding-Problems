import java.io.*;
import java.util.*;

public class StringCompression {

	public static String compression1(String str){
		// write your code here
        StringBuilder temp = new StringBuilder();
        char prev = Character.MIN_VALUE;
        for(char ch: str.toCharArray()){
            if(ch != prev){
                temp.append(ch);
            }
            prev = ch;
        }
		return temp.toString();
	}

	public static String compression2(String str){
		// write your code here
        StringBuilder temp = new StringBuilder();
        int i = 0;
        while(i < str.length()){
            int count = 1;
            char ch = str.charAt(i);
            while(i+1<str.length() && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            temp.append(ch+"");
            if(count > 1){
                temp.append(count);
            }
            i++;
        }
		return temp.toString();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}