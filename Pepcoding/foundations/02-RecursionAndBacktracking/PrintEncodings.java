import java.io.*;
import java.util.*;

public class PrintEncodings {

    static String alphabet = " abcdefghijklmnopqrstuvwxyz";
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printEncodings(str, "");
    }

    public static void printEncodings(String ip, String op) {
        if(ip.length() == 0){
            System.out.println(op);
            return;
        }
        if(ip.length() == 1){
            if(ip.charAt(0) == '0'){
                return;
            } else {
                int ch = ip.charAt(0) - '0';
                op+=alphabet.charAt(ch);
                System.out.println(op);
                return;
            }
        }
        else{
            // left branch
            if(ip.charAt(0) == '0'){
                return;
            } else {
                int ch = ip.charAt(0) - '0';
                String ip1 = ip.substring(1);
                printEncodings(ip1, op + alphabet.charAt(ch));
            }
            // right branch
            String ch2 = ip.substring(0, 2);
            String ip2 = ip.substring(2);
            int num = Integer.parseInt(ch2);
            if(num > 26){
                return;
            } else {
                printEncodings(ip2, op+alphabet.charAt(num));
            }
        }
    }

}