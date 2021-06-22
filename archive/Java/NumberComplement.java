package leetcode;

class NumberComplement {
    public int findComplement(int num) {
        if(num == 0)
            return 1;
        char [] binary = Integer.toString(num, 2).toCharArray();
        for(int i=0; i<binary.length; i++){
            if(binary[i] == '0'){
                binary[i] = '1';
            } else {
                binary[i] = '0';
            }
        }
        return Integer.parseInt(String.valueOf(binary), 2);
    }
}