class L79WordSearch {
    
    //Terribly slow
    public static boolean findWord1(char[][] board, String word, StringBuilder wordSoFar, boolean[][] visited, int row, int col, int index){
        int m = board.length;
        int n = board[0].length;
        
        if(word.equals(wordSoFar.toString())){
            return true;
        }
        
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col] == true || board[row][col] != word.charAt(index)){
            return false;
        }
        
        char currentChar = word.charAt(index);
        visited[row][col] = true;
        wordSoFar.append(currentChar+"");
        boolean right = findWord1(board, word, wordSoFar, visited, row, col+1, index+1);
        boolean down = findWord1(board, word, wordSoFar, visited, row+1, col, index+1);
        boolean up = findWord1(board, word, wordSoFar, visited, row-1, col, index+1);
        boolean left = findWord1(board, word, wordSoFar, visited, row, col-1, index+1);
        visited[row][col] = false;
        wordSoFar.setLength(wordSoFar.length() - 1);
        return right || down || up || left;
    }
    
    static boolean[][] visited;
    static int m;
    static int n;
    
    public static boolean findWord2(char[][] board, String word, boolean[][] visited, int row, int col, int index){
        
        if(index == word.length()){
            return true;
        }
        
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col] == true || board[row][col] != word.charAt(index)){
            return false;
        }
        
        visited[row][col] = true;
        if(
            findWord2(board, word, visited, row, col+1, index+1) || 
            findWord2(board, word, visited, row+1, col, index+1) || 
            findWord2(board, word, visited, row-1, col, index+1) || 
            findWord2(board, word, visited, row, col-1, index+1)
        ){ return true;}
        
        visited[row][col] = false;
        return false;
    }
    
    // without using visited; modifying the board itself
    public static boolean findWord3(char[][] board, String word, int row, int col, int index){
        if(index == word.length()){
            return true;
        }
        
        if(row < 0 || row >= m || col < 0 || col >= n || board[row][col] != word.charAt(index)){
            return false;
        }
        
        board[row][col] = '#';
        if(
            findWord3(board, word, row, col+1, index+1) || 
            findWord3(board, word, row+1, col, index+1) || 
            findWord3(board, word, row-1, col, index+1) || 
            findWord3(board, word, row, col-1, index+1)
        ) return true;
        
        board[row][col] = word.charAt(index);
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        //StringBuilder wordSoFar = new StringBuilder();
        int wordIndex = 0;
        m = board.length;
        n = board[0].length;
        visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                //if(board[i][j] == word.charAt(0) && findWord2(board, word, visited, i, j, wordIndex)){
                if(board[i][j] == word.charAt(0) && findWord3(board, word, i, j, wordIndex)){
                    return true;
                }
            }
        }
        return false;
    }
}