class L1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(stack.isEmpty() || stack.peek() != ch){
                stack.push(ch);
            } else {
                while(!stack.isEmpty() && stack.peek() == ch){
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}