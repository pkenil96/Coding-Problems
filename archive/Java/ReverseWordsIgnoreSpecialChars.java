package string;

class ReverseWordsIgnoreSpecialChars{

	public static String reverseWordUtil(String sentence, int start, int end){
		if(sentence == null || sentence.length() == 0) return sentence;
		//from the sentence we extract the characters starting from
		// start till the end; that would be our word to reverse
		StringBuilder word = new StringBuilder();
		for(int i=start; i<end; i++){
			word.append(sentence.charAt(i));
		}
		return word.reverse().toString();
	}

	//expected output:- "yM eman@#$ si lineK..."
	public static String specialReverse(String sentence){
		// Scan for the entire sentence from left to right
		// Whenever a space or special character is encountered
		// we have found a word, reverse it
		// Maintain two pointers:- begin and end to keep track of the word
		int begin=0, end=0;
		StringBuilder output = new StringBuilder();
		for(int i=0; i<sentence.length(); i++){
			Character ch = sentence.charAt(i);
			// if the character is space or digit, continue
			end++; //end keeps moving till the next space or special character
			if(Character.isLetterOrDigit(ch)==true){
				continue;
			} else {
				//in case of space or special characters, invoke reversal method
				String rev_word = reverseWordUtil(sentence, begin, end-1);
				begin = i+1;
				output.append(rev_word);
				//filling the special character found as it is in the output
				output.append(ch);
			}
		}
		return output.toString();
	}

	public static void main(String[] args) {
		String input = "My name@#$ is Kenil...";
		String output = specialReverse(input);
		System.out.println(input);
		System.out.println(output);
	}
}