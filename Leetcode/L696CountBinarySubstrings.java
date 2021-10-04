
class L696CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            int count=1;
            while(i+1<s.length() && chars[i] == chars[i+1]){
                count++;
                i++;
            }
            list.add(count);
        }
        int ans=0;
        for(int i=0; i<list.size()-1; i++){
            ans+=Math.min(list.get(i), list.get(i+1));
        }
        return ans;
    }
}