import java.io.*;
import java.util.*;

public class SQ2BalancedBrackets {

    public static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else if(ch == ')' || ch == ']' || ch == '}'){
                if(stack.isEmpty()){
                    return false;
                } else if(ch == ')' && stack.peek() != '('){
                    return false;
                } else if(ch == ']' && stack.peek() != '['){
                    return false;
                } else if(ch == '}' && stack.peek() != '{'){
                    return false;
                }
                stack.pop();
            } 
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(isBalanced(input));
    }

}