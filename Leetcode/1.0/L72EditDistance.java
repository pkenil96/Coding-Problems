import java.util.*;

class L72EditDistance {
     
    public int minDistance(String s1, String s2, HashMap<String, Integer> memo){
        int m = s1.length();
        int n = s2.length();
        String key = m+"-"+n;
        
        if(memo.containsKey(key)){
            return memo.get(key);
        } else {
            if(m == 0){
                return n;
            }
            if(n == 0){
                return m;
            }
            if(s1.charAt(m-1) == s2.charAt(n-1)){
                return minDistance(s1.substring(0, m-1), s2.substring(0, n-1));
            }
            int replace = 1 + minDistance(s1.substring(0, m-1), s2.substring(0, n-1));
            int insert = 1 + minDistance(s1.substring(0, m-1), s2);
            int delete = 1 + minDistance(s1, s2.substring(0, n-1));
            int res = Math.min(replace, Math.min(insert, delete));
            key = m+"-"+n;
            memo.put(key, res);
            return res;
        }
    }
    
    public int minDistance(String s1, String s2) {
        //HashMap<String, Integer> memo = new HashMap<>();
        int m = s1.length();
        int n = s2.length();
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        int[][] dp = new int[m+1][n+1];
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
                    int del = dp[i-1][j];
                    int ins = dp[i][j-1];
                    int rep = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(rep, Math.min(ins, del));
                }
            }
        }
        return dp[m][n];
        //return minDistance(s1, s2, memo);
    }
}