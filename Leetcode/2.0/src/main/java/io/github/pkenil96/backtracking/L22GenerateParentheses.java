package io.github.pkenil96.backtracking;

import java.util.ArrayList;
import java.util.List;

public class L22GenerateParentheses {
	public static void backtrack(int open, int close, StringBuilder sb, List<String> result){
        if(open > close || open<0 || close<0){
            return;
        }
        if(open == 0 && close == 0){
            result.add(sb.toString());
            return;
        }
        sb.append("(");
        backtrack(open-1, close, sb, result);
        sb.setLength(sb.length()-1);
        sb.append(")");   
        backtrack(open, close-1, sb, result);
        sb.setLength(sb.length()-1);
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int open=n, close=n;
        backtrack(open, close, new StringBuilder(), result);
        return result;
    }
}
