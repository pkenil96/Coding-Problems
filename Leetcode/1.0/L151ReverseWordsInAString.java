class L151ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] words = s.split("\\s+");
        for(int i=words.length-1; i>=0; i--){
            if(words[i].trim().length() > 0){
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}