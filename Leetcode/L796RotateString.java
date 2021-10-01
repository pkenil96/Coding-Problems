class L796RotateString {
    
    private static String stringRotate(String s, int k){
        StringBuilder sb = new StringBuilder();
        String firstHalf = s.substring(s.length() - k);
        String secondHalf = s.substring(0, s.length() - k);
        sb.append(firstHalf);
        sb.append(secondHalf);
        return sb.toString();
    }
    
    // brute force
    public static boolean solution1(String s1, String s2){
        for(int i=1; i<s2.length(); i++){
            String rotatedITimes = stringRotate(s2, i);
            if(s1.equals(rotatedITimes)){
                return true;
            }
        }
        return false;
    }
    
    private static boolean rotateUtil(String s1, String s2, int k){
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt((i+k)%s2.length())){
                return false;
            }
        }
        return true;
    }
    
    public static boolean solution2(String s1, String s2){
        for(int i=0; i<s1.length(); i++){
            if(rotateUtil(s1, s2, i)){
                return true;
            }
        }
        return false;
    }
    
    public boolean rotateString(String s1, String s2) {
        if(s1 == null || s2 == null){
            return false;
        }
        
        if(s1.length() != s2.length()){
            return false;
        }
        
        if(s1.length() == 0){
            return true;
        }
        //return solution1(s1, s2);
        return solution2(s1, s2);
        // return solution3;
    }
}