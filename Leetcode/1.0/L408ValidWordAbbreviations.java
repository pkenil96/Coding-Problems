class L408ValidWordAbbreviations {
    public boolean validWordAbbreviation(String word, String abbr) {
        int num=0, index=0;
        for(char ch: abbr.toCharArray()){
            // case of leading zeros
            if(ch == '0' && num == 0){
                return false;
            } else if(ch >= '0' && ch <= '9'){
                num = num * 10 + (ch-'0');
            } else {
                index += num;
                if(index < word.length() && word.charAt(index) != ch){
                    return false;
                }
                num = 0;
                index++;
            }
        }
        return (index+num) == word.length() ? true: false;
    }
}