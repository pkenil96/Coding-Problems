/*
1. You are given a string exp representing an expression.
2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
3. But, some of the pair of brackets maybe extra/needless. 
4. You are required to print true if you detect extra brackets and false otherwise.

e.g.'
((a + b) + (c + d)) -> false
(a + b) + ((c + d)) -> true
*/
import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets{
	public static boolean hasDuplicateBrackets(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == ')'){
                if(stack.peek() == '('){
                    return true;
                } else {
                    while(stack.peek() != '('){
                        stack.pop();
                    }
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        System.out.println(hasDuplicateBrackets(inp));
    }
}