import java.util.*;

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
    
    public boolean exists(String word){
        TrieNode runner = root;
        for(char ch: word.toCharArray()){
            if(runner.children[ch - 'a'] == null){
                return false;
            } else {
                runner = runner.children[ch - 'a'];
            }
        }
        return runner.isEnd;
    }
    
    public boolean prefixExists(String word){
        TrieNode runner = root;
        for(char ch: word.toCharArray()){
            if(runner.children[ch - 'a'] == null){
                return false;
            } else {
                runner = runner.children[ch - 'a'];
            }
        }
        return true;
    }
    
    private void getAllWordsWithPrefixUtil(TrieNode startNode, String prefix, List<String> strings, StringBuilder soFar){
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

public class TrieMain {
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("Inserting: [mobile, mouse, moneypot, monitor, mousepad]");
        trie.insert("mobile");
        trie.insert("mouse");
        trie.insert("moneypot");
        trie.insert("monitor");
        trie.insert("mousepad");
        //System.out.println("All words starting with \"m\": " + trie.getAllWordsWithPrefix("m").toString());
        //System.out.println("All words starting with \"mo\": " + trie.getAllWordsWithPrefix("mo").toString());
        System.out.println("All words starting with \"mou\": " + trie.getAllWordsWithPrefix("mou").toString());
        System.out.println("All words starting with \"mous\": " + trie.getAllWordsWithPrefix("mous").toString());
        System.out.println("All words starting with \"mouse\": " + trie.getAllWordsWithPrefix("mouse").toString());
        

        /*Trie trie = new Trie();
        System.out.println("Inserting: [bat, ball, beer, bady, ape, apex, bull]");
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("beer");
        trie.insert("bady");
        trie.insert("ape");
        trie.insert("apex");
        trie.insert("bull");

        System.out.println("beer exists: " + trie.exists("beer"));
        System.out.println("beet exists: " + trie.exists("beet"));
        System.out.println("bull exists: " + trie.exists("bull"));
        System.out.println("b exists: " + trie.exists("b"));

        System.out.println("Prefix \"be\" exists: " + trie.prefixExists("be"));
        System.out.println("Prefix \"ba\" exists: " + trie.prefixExists("ba"));
        System.out.println("Prefix \"ape\" exists: " + trie.prefixExists("ape"));

        System.out.println("All words starting with \"ba\": " + trie.getAllWordsWithPrefix("ba").toString());
        System.out.println("All words starting with \"b\": " + trie.getAllWordsWithPrefix("b").toString());*/
    }
}