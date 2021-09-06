import java.io.*;
import java.util.*;

public class ConsecutiveCharacterDifference {

	public static String solution(String str){
		StringBuilder res = new StringBuilder();
        int i;
        for(i=0; i<str.length()-1; i++){
            res.append(str.charAt(i));
            res.append(str.charAt(i+1) - str.charAt(i));
            //res.append(str.charAt(i+1));
        }
        res.append(str.charAt(i));
		return res.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}