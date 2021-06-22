package leetcode;

class AnagramsNoHashMap{

	public static boolean checkIfAnagrams(String s1, String s2){
		if(s1.length() != s2.length())
			return false;

		//creating an integer array with 26 cells
		int [] alphabets = new int[26];

		//converting both the input strings into character array
		char [] sc1 = s1.toLowerCase().toCharArray();
		char [] sc2 = s2.toLowerCase().toCharArray();
		
		for(int i=0; i<s1.length(); i++){
			alphabets[sc1[i]-'a']++;
			alphabets[sc2[i]-'a']--;
		}
		//in case both the strings are anagrams, alphabets should contain all zeroes
		for(int i=0; i<alphabets.length; i++){
			if(alphabets[i] != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		//checking if two strings are anagrams or not without using
		//sorting or the hashmap
		if(args.length != 2){
			System.out.println("Please provide two strings to check if anagram.");
			System.exit(-1);			
		}
		String s1 = args[0];
		String s2 = args[1];
		System.out.println(checkIfAnagrams(s1, s2));
	}
}