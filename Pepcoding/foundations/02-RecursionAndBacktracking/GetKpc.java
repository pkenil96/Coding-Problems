import java.util.Scanner;
import java.util.ArrayList;

public class GetKpc{

	static HashMap<Character, String> map;

	public static void getKPC(String str, String temp, ArrayList<String> res) {
    	if(str.length() == 0){
    		res.add(temp);
    		return;
    	}
    	for(char ch: map.get(str.charAt(0)).toCharArray()){
    		getKPC(str.substring(1), temp+ch, res);
    	}
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		
		map = new HashMap<>();
		map.put('0', ".;");
		map.put('1', "abc");
		map.put('2', "def");
		map.put('3', "ghi");
		map.put('4', "jkl");
		map.put('5', "mno");
		map.put('6', "pqrs");
		map.put('7', "tu");
		map.put('8', "vwx");
		map.put('9', "yz");
		ArrayList<String> res = new ArrayList<>();
		getKPC(num, "", res);
		System.out.println(res);
	}

}