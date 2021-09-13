/*
    https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-subsequence-official/ojquestion
*/

import java.util.Scanner;
import java.util.ArrayList;

public class GetSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(gss(str));
    }

    public static void gssUtil(String str, String temp, ArrayList<String> ans){
        if(str.length() == 0){
            ans.add(temp);
            return;
        }
        
        // right branch we exclude the character at 0th position and recurse on the remaining string
        gssUtil(str.substring(1), temp, ans);
        // left branch we include the character at 0th position and recurse on the remaining string
        gssUtil(str.substring(1), temp+str.charAt(0), ans);
        
    }
    
    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            return new ArrayList<>();
        }
        ArrayList<String> ans = new ArrayList<>();
        gssUtil(str, "", ans);
        return ans;
    }
}