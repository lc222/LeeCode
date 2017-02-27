import java.util.HashSet;
import java.util.Set;

public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
    	Set<Character> rows = new HashSet<>();
        Set<Character> columns = new HashSet<>();
        Set<Character> cube = new HashSet<>();
    	for(int i = 0; i<9; i++){
            
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
            rows.clear();
            columns.clear();
            cube.clear();
        }
        return true;
	}
    
    public static boolean isValidSudoku1(char[][] board) {
	    int [] vset = new int [9];
	    int [] hset = new int [9];
	    int [] bckt = new int [9];
	    int idx = 0;
	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            if (board[i][j] != '.') {
	                idx = 1 << (board[i][j] - '0') ;
	                if ((hset[i] & idx) > 0 || (vset[j] & idx) > 0 ||
	                    (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
	                hset[i] |= idx;
	                vset[j] |= idx;
	                bckt[(i / 3) * 3 + j / 3] |= idx;
	            }
	        }
	    }
	    return true;
    }
    //用字符串的方式来表示相应元素是否出现过
    public boolean isValidSudoku2(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }
    
    
    static char[][] board = {{'.','8','7','6','5','4','3','2','1'}, {'2','.','.','.','.','.','.','.','.'}, {'3','.','.','.','.','.','.','.','.'}, 
    		{'4','.','.','.','.','.','.','.','.'}, {'5','.','.','.','.','.','.','.','.'}, {'6','.','.','.','.','.','.','.','.'}, 
    		{'7','.','.','.','.','.','.','.','.'}, {'8','.','.','.','.','.','.','.','.'}, {'9','.','.','.','.','.','.','.','.'}};
    
	public static void main(String[] args){
		boolean res = isValidSudoku1(board);
		System.out.println(res);
		
	}
}
