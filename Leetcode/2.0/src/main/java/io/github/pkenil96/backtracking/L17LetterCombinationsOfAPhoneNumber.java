package io.github.pkenil96.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17LetterCombinationsOfAPhoneNumber {
	
	private Map<Character, String> hmap;
  
    public void backtrack(String input, StringBuilder output, List<String> result){
        if(input.length() == 0){
            result.add(output.toString());
            return;
        }
        char currentDigit = input.charAt(0);
        String currentDigitString = hmap.get(currentDigit);
        for(int i=0; i<currentDigitString.length(); i++){
        	output.append(currentDigitString.charAt(i));
            backtrack(input.substring(1), output, result);
            output.setLength(output.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        hmap = new HashMap<>();
        hmap.put('2', "abc");
        hmap.put('3', "def");
        hmap.put('4', "ghi");
        hmap.put('5', "jkl");
        hmap.put('6', "mno");
        hmap.put('7', "pqrs");
        hmap.put('8', "tuv");
        hmap.put('9', "wxyz");
        backtrack(digits, new StringBuilder(), result);
        return result;
    }
}
