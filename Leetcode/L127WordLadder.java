class L127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String curr = q.poll();
                if(curr.equals(endWord)){
                    return level;
                }
                for(int j=0; j<curr.length(); j++){
                    for(int k='a'; k<='z'; k++){
                        char[] wordChars = curr.toCharArray();
                        wordChars[j] = (char)k;
                        String temp = new String(wordChars);
                        if(set.contains(temp) && !visited.contains(temp)){
                            q.add(temp);
                            visited.add(temp);
                        }
                    }
                }
                if(q.size() == 0 && !curr.equals(endWord)){
                    return 0;
                }
            }
            level++;
        }
        return level;
    }
}