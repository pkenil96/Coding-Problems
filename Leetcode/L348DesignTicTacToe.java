

class L348DesignTicTacToe {
    
    int boardSize;
    int[] counts;
    int[][] board;
    
    public L348DesignTicTacToe(int n) {
        boardSize = n;
        counts = new int[2];
        board = new int[boardSize][boardSize];
    }
    
    public int winner(int row, int col, int player){
        // we check the row, column and diagonal corresponding
        // to the current move's row and column
        
        int currCol, currRow;
        // checking the row corresponding to the current move's row
        for(currCol=0; currCol<boardSize; currCol++){
            if(board[row][currCol] != player){
                break;
            }
        }
        if(currCol == boardSize){
            return player;
        }
        // checking the column corresponding to the current move's column
        for(currRow=0; currRow<boardSize; currRow++){
            if(board[currRow][col] != player){
                break;
            }
        }
        if(currRow == boardSize){
            return player;
        }
        // checking the diagonal corresponding to the current move's row and column      
        if(row == col){ // valid condition for qualifying for left to right download
            int i;
            for(i=0; i<boardSize; i++){
                if(board[i][i] != player){
                    break;
                }
            }
            if(i == boardSize){
                return player;
            }
        } if(row + col == boardSize - 1) {
            for(currRow=boardSize-1, currCol=0; currRow>=0 && currCol<boardSize; currRow--, currCol++){
                if(board[currRow][currCol] != player){
                    break;
                }
            }
            if(currCol == boardSize){
                return player;
            }
        }
        return 0;
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        counts[player-1]++;
        if(counts[player-1] < boardSize){
            return 0;
        }
        return winner(row, col, player);
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */