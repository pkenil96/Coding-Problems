import java.util.*;

public class StringPermutation {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String ip = sc.next();
        String op = "";
        printPermutations(ip, op);
    }

    public static void printPermutations(String ip, String op) {
        if(ip.length() == 0){
            System.out.println(op);
            return;
        }
        
        for(int i=0; i<ip.length(); i++){
            String ipExcludingIthChar = ip.substring(0, i) + ip.substring(i+1);
            printPermutations(ipExcludingIthChar, op+ip.charAt(i));    
        }
    }

}