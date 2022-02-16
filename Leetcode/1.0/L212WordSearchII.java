import java.util.*;

class L212WordSearchII {
    static int m;
    static int n;
    public static boolean findWord(char[][] board, String word, int row, int col, int index, boolean[][] visited){
        
        if(index == word.length()){
            return true;
        }
        
        if(row < 0 || row >= m || col < 0 || col >= n || board[row][col] != word.charAt(index) || visited[row][col] == true){
            return false;
        }
        
        visited[row][col] = true;
        if(
            findWord(board, word, row, col+1, index+1, visited) || 
            findWord(board, word, row+1, col, index+1, visited) || 
            findWord(board, word, row-1, col, index+1, visited) || 
            findWord(board, word, row, col-1, index+1, visited)
        ) return true;
        
        visited[row][col] = false;
        return false;
    }

    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        
        for(int k=0; k<words.length; k++){
            String word = words[k];
            boolean found=false;
            boolean[][] visited = new boolean[m][n];
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j] == word.charAt(0) && findWord(board, word, i, j, 0, visited)){
                        result.add(word);
                        found=true;
                        break;
                    }
                }
                if(found) break;
            }
        }
        return result;
    }
}