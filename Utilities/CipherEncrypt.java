public class CipherEncrypt{
   
	public String decrypt(String plainText, int shift) {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
    	String input = "All-convoYs-9-be:Alert1.";
        String expected = "Epp-gsrzsCw-3-fi:Epivx5.";
        StringBuilder sb = new StringBuilder();
        int key = 4;
        key %= 26;
        for(int i=0; i<input.length(); i++){
        	int num;
        	char cnum;
        	char ch = input.charAt(i);
        	if(Character.isLetter(ch)) {
        		num = (ch + key);
        		cnum = (char)num;
        		sb.append(cnum);
        	} else if(Character.isDigit(ch)) {
        		num = (Character.getNumericValue(ch) + key) % 10;
        		sb.append(num);
        	} else {
        		sb.append(ch);
        	}
        }
        String output = sb.toString();
        System.out.println(output);
        System.out.println(expected);
    }
}