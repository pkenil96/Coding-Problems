package ctci;

class UniqueChars{
	/*
		Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
	*/

	// Assumptions
	//1. The input string contains only alphabets
	//2. Lowercase letters are equivalent to uppercase leters
	//3. In case the string is empty, it will return false

	public static boolean isUnique(String s) {
		if(s.length() == 0 || s==null) return false;

		String str = s.toLowerCase();
				
		int [] alphabets = new int[26];
		//System.out.println((int)'z'-96);
		for(int i=0; i<str.length(); i++){
			//check if there is any non alphabet character, return error
			if(! Character.isLetter(str.charAt(i))){
				System.out.println("Invalid Input");
				System.exit(-1);
			}
			int index = (int)str.charAt(i) - 96;
			alphabets[index] += 1;
		}

		for(int i=0; i<26; i++){
			if(alphabets[i] > 1)
				return false;
		}
		return true;
	}

	public static void main(String [] args) throws Exception{
		String unique = "TIger";
		String notUnique = "aPPLe";
		String invalid1 = "kenil123";
		String invalid2 = "$$123";	
		System.out.println(isUnique(unique));
		System.out.println(isUnique(notUnique));
		System.out.println(isUnique(invalid1));
		System.out.println(isUnique(invalid2));
	}
}