class Trie{    
    TrieNode root;
    static class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        
        TrieNode(){
            children = new TrieNode[26];
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            isEnd = false;
        }
    }
    
    public Trie(){
        this.root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode runner = root;
        for(char ch: word.toCharArray()){
            if(runner.children[ch - 'a'] == null){
                runner.children[ch - 'a'] = new TrieNode();
            }
            runner = runner.children[ch - 'a'];
        }
        runner.isEnd = true;
    }
    
    private void getAllWordsWithPrefixUtil(TrieNode startNode, String prefix, List<String> strings, StringBuilder soFar){
        if(strings.size() == 3){
            return;
        }
        if(startNode.isEnd){
            StringBuilder ans = new StringBuilder();
            ans.append(prefix);
            ans.append(soFar.toString());
            strings.add(ans.toString());
            //return;
        }

        for(int i=0; i<26; i++){
            TrieNode child = startNode.children[i];
            if(child == null){
                continue;
            }
            int ch = i + 'a';
            soFar.append(""+(char)ch);
            getAllWordsWithPrefixUtil(child, prefix, strings, soFar);
            soFar.setLength(soFar.length() - 1);
        }

    }
    
    public List<String> getAllWordsWithPrefix(String prefix){
        List<String> strings =  new ArrayList<>();
        TrieNode runner = root;
        for(char ch: prefix.toCharArray()){
            if(runner.children[ch - 'a'] == null){
                // in case prefix is not present in the trie, return empty list
                return strings;
            } else {
                runner = runner.children[ch - 'a'];
            }
        }
        getAllWordsWithPrefixUtil(runner, prefix, strings, new StringBuilder());
        return strings;
    }
}


class L1268SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        Trie trie = new Trie();
        for(String product: products){
            trie.insert(product);
        }
        
        String query = "";
        for(char ch: searchWord.toCharArray()){
            query += ch;
            List<String> words = trie.getAllWordsWithPrefix(query);
            //Collections.sort(words);
            List<String> temp = new ArrayList<>();
            for(int i=0; i<words.size(); i++){
                if(i == 3){
                    break;
                }
                temp.add(words.get(i));
            }
            result.add(temp);
        }
        return result;
    }
}