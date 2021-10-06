class L242ValidAnagram {
    
    public boolean solution0(String s, String t) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for(int i=0; i<s.length(); i++){
            map1[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<t.length(); i++){
            map2[t.charAt(i) - 'a']++;
        }
        for(int i=0; i<26; i++){
            if(map1[i] != map2[i]){
                return false;
            }
        }
        return true;
    }
    
    public boolean solution1(String s, String t) {
        int[] map = new int[26];
        for(int i=0; i<s.length(); i++){
            map[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<t.length(); i++){
            map[t.charAt(i) - 'a']--;
        }
        for(int i=0; i<26; i++){
            if(map[i] != 0){
                return false;
            }
        }
        return true;
    }
    
    public boolean isAnagram(String s, String t){
        //return solution0(s, t);
        return solution1(s, t);
    }
}