package leetcode;

class WordSearch{
	
	//to keep track of all the cells that have been already visited
	static boolean [][] visited;

	public static boolean search(int i, int j, int wordIndex, char [][] board, String word){

		if(wordIndex == word.length())
			return true;
		if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] || word.charAt(wordIndex) != board[i][j])
			return false;
		visited[i][j] = true;

		//checking left, right, up and down
		if(
			search(i+1, j, wordIndex+1, board, word) ||
			search(i-1, j, wordIndex+1, board, word) ||
			search(i, j+1, wordIndex+1, board, word) ||
			search(i, j-1, wordIndex+1, board, word) 
		) return true;
		//in case we don't find the desired character in the board in any 
		//of the direction, we mark that cell as not visited
		visited[i][j] = false;
	return false;
	}

	public static boolean WordSearchUtil(char [][] board, String word){
		int rows = board.length;
		int cols = board[0].length;
		visited = new boolean[rows][cols];
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(board[i][j] == word.charAt(0) && search(i, j, 0, board, word)){
					return true;
				}
			}
		} return false;
	}

	public static void printBoard(char [][] board){
		int cols = board[0].length;
		int rows = board.length;
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("Usage: java WordSearch <word>");
			System.exit(-1);
		}
		String word = args[0].toUpperCase();
		char [][] board = {{'A','B','C','E'},
  						   {'S','F','C','S'},
  						   {'A','D','E','E'}};
		printBoard(board);
		System.out.println(WordSearchUtil(board, word));
}
}