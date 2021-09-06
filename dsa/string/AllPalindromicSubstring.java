public class AllPalindromicSubstring{
	
	public static boolean isPalindrome(String str){
        if(str.length() == 0){
            return true;
        }
        int start = 0;
        int end = str.length() - 1;
        
        while(start <= end){
            if(str.charAt(start++) != str.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    
    public static ArrayList<String> bruteForce(String s) {
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            String temp = "";
            for(int j=i; j<s.length(); j++){
                temp+=s.charAt(j);
                if(isPalindrome(temp)){
                    ans.add(temp);
                }
            }
        }
        return temp;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ArrayList<String> pstrings = bruteForce(str);
		for(String pstring: pstrings){
			System.out.println(pstring);
		}
	}
}