class L583DeleteOperationForTwoStrings {
    
    public static int minDis(String s1, String s2, HashMap<String, Integer> memo){
        int m = s1.length();
        int n = s2.length();
        String key = m+"-"+n;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return minDis(s1.substring(0, m-1), s2.substring(0, n-1), memo);
        }
        else{
            int deleteFromS1 = minDis(s1.substring(0, m-1), s2, memo);
            int deleteFromS2 = minDis(s1, s2.substring(0, n-1), memo);
            int val = 1+Math.min(deleteFromS1, deleteFromS2);
            key = m+"-"+n;
            memo.put(key, val);
            return val;
        }
    }
    
    public int minDistance(String s1, String s2) {
        //HashMap<String, Integer> memo= new HashMap<>();
        // top down
        //return minDis(word1, word2, memo);
        int m = s1.length();
        int n = s2.length();
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=1; i<=m; i++){
            dp[i][0] = i;
        }
        for(int i=1; i<=n; i++){
            dp[0][i] = i;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}