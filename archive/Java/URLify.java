package ctci;

/*URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: " M r 3ohn S m i t h
Output: "Mr%203ohn%20Smith*/
class URLify{

	public static char[] URLifyUtil(char [] charstr){
		int orgLen = charstr.length;
		int spaces=0, charLen=0, newLen=0, i, j;
		for(i=0; i<orgLen; i++){
			if(charstr[i] == ' '){
				spaces++;
			}
		}
		//there is a chance that there might be trailing spaces
		//we need not take that into consideration while we
		//compute the string length, hence we need to subtract it
		while(charstr[i-1] == ' '){
			spaces--;
			i--;
		}
		int old_index = i-1;
		charLen = i - spaces;
		newLen = charLen + spaces*3;
		//now the spaces variable contains count of non trailing spaces
		//since we cannot resize the character array, we copy its content
		//in temporary variable and create a new char array with new len

		char [] temp = charstr;
		charstr = new char[newLen];

		for(i=newLen-1, j=old_index; i>=0 && j>=0; i--, j--){
			if(temp[j] == ' '){
				charstr[i] = '0';
				charstr[i-1] = '2';
				charstr[i-2] = '%';
				i = i-2;
			} else {
				charstr[i] = temp[j];
			}
		}
		return charstr;
	}

	public static void main(String[] args) {
		String str = "Hey there I am using Java! Wow bro.         ";
		char [] charstr = str.toCharArray();
		System.out.println(URLifyUtil(charstr));
	}
}