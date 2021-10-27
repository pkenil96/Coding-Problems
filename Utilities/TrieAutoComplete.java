class TrieAutoComplete {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
            children = new TrieNode[26];
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            isEnd = false;
        }
    }
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(char ch: word.toCharArray()){
            if(temp.children[ch - 'a'] == null){
                temp.children[ch - 'a'] = new TrieNode();
            }
            temp = temp.children[ch - 'a'];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        if(root == null){
            return false;
        }
        TrieNode temp = root;
        for(char ch: word.toCharArray()){
            if(temp.children[ch - 'a'] == null){
                return false;
            }
            temp = temp.children[ch - 'a'];
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        if(root == null){
            return false;
        }
        TrieNode temp = root;
        for(char ch: prefix.toCharArray()){
            if(temp.children[ch - 'a'] == null){
                return false;
            }
            temp = temp.children[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */