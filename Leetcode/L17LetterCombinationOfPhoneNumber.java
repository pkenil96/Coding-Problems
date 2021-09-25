class L17LetterCombinationOfPhoneNumber {
    
    static HashMap<Character, String> map;
    
    /*public static void backtrack(String input, String output, int index, List<String> result){
        if(index == input.length()){
            result.add(output);
            return;
        }
        char ch = input.charAt(index);
        for(int i=0; i<map.get(ch).length(); i++){
            backtrack(input, output+map.get(ch).charAt(i), index+1, result);
        }    
    }*/
    
    // version with StringBuilder is faster than String
    public static void backtrack(String input, StringBuilder output, int index, List<String> result){
        if(index == input.length()){
            result.add(output.toString());
            return;
        }
        char ch = input.charAt(index);
        for(int i=0; i<map.get(ch).length(); i++){
            output.append(map.get(ch).charAt(i));
            backtrack(input, output, index+1, result);
            output.setLength(output.length() - 1);
        }    
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        backtrack(digits, new StringBuilder(), 0, res);
        return res;
    }

}