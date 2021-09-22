class L1143LongestCommonSubsequence {
    
    public static int topDown(String s1, String s2, HashMap<String, Integer> memo){
        // s1 being the longer string than s2
        int m = s1.length();
        int n = s2.length();
        String key = m + "-" + n;
        if(m == 0 || n == 0){
            return 0;
        } else if(memo.containsKey(key)) {
            return memo.get(key);
        } else {
            if(s1.charAt(m-1) == s2.charAt(n-1)){
                int res =  1 + topDown(s1.substring(0, m-1), s2.substring(0, n-1), memo);
                memo.put(key, res);
                return res;
            } else {
                int first = topDown(s1.substring(0, m-1), s2, memo);
                int second = topDown(s1, s2.substring(0, n-1), memo);
                int res = Math.max(first, second);
                memo.put(key, res);
                return res;
            }
        }
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        //HashMap<String, Integer> memo = new HashMap<>();
        String s1 = (text1.length() >= text2.length()) ? text1 : text2;
        String s2 = (text1.length() < text2.length()) ? text1 : text2;
        //return topDown(s1, s2, memo);
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<=n; i++){
            dp[0][i] = 0;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}