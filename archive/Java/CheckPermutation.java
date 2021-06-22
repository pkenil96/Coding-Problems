package ctci;

import java.util.HashMap;
import java.util.Scanner;

class CheckPermutation{

	public static boolean checkPermutationUtil(String str1, String str2){
		if(str1 == null || str2 == null || str1.length() ==0 || str2.length() == 0) return false;
		//Creating two hashmaps, one for each string
		HashMap <Character, Integer> mapStr1 = new HashMap <Character,Integer>();
		HashMap <Character, Integer> mapStr2 = new HashMap <Character,Integer>();

		//populating the char-freq of str1 in mapStr1
		for(int i=0; i<str1.length(); i++){
			Character ch = str1.charAt(i);
			if(mapStr1.containsKey(ch)){
				mapStr1.put(ch, mapStr1.get(ch)+1);
			} else {
				mapStr1.put(ch, 1);
			}
		}

		//populating the char-freq of str2 in mapStr2
		for(int i=0; i<str2.length(); i++){
			Character ch = str2.charAt(i);
			if(mapStr2.containsKey(ch)){
				mapStr2.put(ch, mapStr2.get(ch)+1);
			} else {
				mapStr2.put(ch, 1);
			}
		}
		//identical maps indicates strings are permutation
		if(mapStr1.equals(mapStr2))
			return true;
		return false;
	}

	public static void main(String[] args) {
		if(args.length != 2){
			System.out.println("Usage: java CheckPermutation <string1> <string2>");
			System.exit(-1);
		}

		String str1 = args[0];
		String str2 = args[1];
		System.out.println(checkPermutationUtil(str1, str2));
	}
}