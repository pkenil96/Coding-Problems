class L419BattleshipsInBoard {
    public int countBattleships(char[][] board) {
        int ans = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(i == 0){
                    if(j == 0 && board[i][j] == 'X'){
                        ans++;
                    } else if(board[i][j] == 'X' && board[i][j-1] != 'X'){
                        ans++;
                    }
                } else if(j == 0){
                    if(i == 0 && board[i][j] == 'X'){
                        ans++;
                    } else if(board[i][j] == 'X' && board[i-1][j] != 'X'){
                        ans++;
                    }
                } else {
                    if(board[i-1][j] != 'X' && board[i][j-1] != 'X' && board[i][j] == 'X'){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}