class L17LetterCombinationOfPhoneNumber {
    
    static HashMap<Character, String> map;
    
    public static void backtrack(String input, String output, List<String> result){
        if(input.length() == 0){
            result.add(output);
            return;
        }
        char ch = input.charAt(0);
        for(int i=0; i<map.get(ch).length(); i++){
            backtrack(input.substring(1), output+map.get(ch).charAt(i), result);
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
        backtrack(digits, "", res);
        return res;
    }
}