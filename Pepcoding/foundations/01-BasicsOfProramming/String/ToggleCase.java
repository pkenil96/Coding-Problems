import java.util.Scanner;

public class ToggleClass{
	public static String toggleCase(String str){
		//write your code here
		StringBuilder ans = new StringBuilder();
		for(char ch: str.toCharArray()){
			if(Character.isUpperCase(ch)){
				ans.append(Character.toLowerCase(ch));
			} else {
				ans.append(Character.toUpperCase(ch));
			}
		}
		return ans.toString();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}
}