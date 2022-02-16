import java.util.*;

class L20ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '('  || ch == '[' || ch == '{'){
                stack.push(ch);
            } else if(stack.isEmpty()){
                return false;
            } else {
                char top = stack.pop();
                if(ch == ')' && top != '('){
                    return false;
                } else if(ch == '}' && top != '{'){
                    return false;
                } else if(ch == ']' && top != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}