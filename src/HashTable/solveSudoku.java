package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class solveSudoku {
    public void solveSudoku0(char[][] board) {
    	if(board == null || board.length == 0)
    		return;
    	solve(board);
    }

	private boolean solve(char[][] board){
    	for(int i=0; i<board.length; i++){
    		for(int j=0; j<board.length; j++){
    			if(board[i][j] == '.'){
    				for(char c='1'; c<='9'; c++){
    					if(isValid(board, i, j, c)){
    						board[i][j] = c;
    						if(solve(board))
    							return true;
    						else
    							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char c){
		for(int i = 0; i < 9; i++) {
			if(board[i][col] != '.' && board[i][col] == c) return false; //check row
			if(board[row][i] != '.' && board[row][i] == c) return false; //check column
			if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
					board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
		}
		return true;
	}

	int[][] map1;  //map1, map2, map3 represents the row, coloum, grid check of suduku.
	int[][] map2;       //e.g. map1[2][3] means the number '4' has been existed in row 3.
	int[][] map3;
	char[][] board;
	public void solveSudoku(char[][] board) {
		this.board = board;
		map1 = new int[9][9];
		map2 = new int[9][9];
		map3 = new int[9][9];
		// initialization with the original board.
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				if(board[i][j]!='.'){
					int num = board[i][j]-'0'-1;
					map1[i][num] = 1;
					map2[j][num] = 1;
					map3[(i/3)*3+j/3][num] = 1;
				}
			}
		}
		solve(0);
	}

	private boolean solve(int count){
		if(count>=81 ){ // if the pointer exceeds the end of the board,there is a solution.
			return true;
		}
		for(int i = count; i<81; i++){  // the loop starts from the current call.
			int ii = i/9;     // transfer the 1 dimensional position to 2 dim position.
			int jj = i%9;
			if(board[ii][jj]!='.') continue;
			else{
				for(int k =0; k<9; k++){
					// if there is a conflict, we choose the next number from 1 to 9.
					if(map1[ii][k]==1||map2[jj][k]==1||map3[(ii/3)*3+jj/3][k]==1) continue;
					else{
						board[ii][jj] = (char)(k+49);
						map1[ii][k] = 1;
						map2[jj][k] = 1;
						map3[3*(ii/3)+jj/3][k] = 1;
						if(solve(ii*9+jj+1)==true) return true;
						// If there is not a solution found in the next recursion call,
						// then we recover, the current board and restriction arrays.
						map1[ii][k] = 0;
						map2[jj][k] = 0;
						map3[3*(ii/3)+jj/3][k] = 0;
						board[ii][jj] = '.';
					}
				}
				// If there is no solution found from 1 to 9, then we go back to the last recursion call.
				return false;
			}
		}
		// This is trivial just to be correspond with the return type.
		return true;
	}
}
