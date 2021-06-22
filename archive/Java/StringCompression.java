package leetcode;

class StringCompression{
    public static String compressString(String word){
        StringBuilder s = new StringBuilder();
        for(int i=0; i<word.length()-1; i++){
            
        }
        return s.toString();
    }
    public static void main(String [] args){
        String inp1 = "aaabccd"; //output = "a3b1c2d1"
        System.out.println(inp1);
        System.out.println(compressString(inp1));
    }
}