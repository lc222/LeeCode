package Array;

/**
 * Created by liuchong on 2017/4/21.
 */
public class exist {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, chs, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int idx, int x, int y) {
        if (idx == words.length) {
            return true;
        }
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return false;
        }
        if (board[x][y] != words[idx]) {
            return false;
        }
        board[x][y] ^= 256;
        boolean exist = dfs(board, words, idx + 1, x, y + 1) ||
                dfs(board, words, idx + 1, x, y - 1) || dfs(board, words, idx + 1, x + 1, y) ||
                dfs(board, words, idx + 1, x - 1, y) ;
        board[x][y] ^= 256;
        return exist;
    }

    public static boolean dfs(char[][] board, String word, int row, int col, int index, int flag){
        if(index == word.length())
            return true;
        if(row >= 1 && flag != 1 && board[row-1][col] == word.charAt(index))
            dfs(board, word, row-1, col, index+1, 4);
        if(col >= 1 && flag != 3 && board[row][col-1] == word.charAt(index))
            dfs(board, word, row, col-1, index+1, 2);
        if(col < board[0].length-1 && flag != 2 && board[row][col+1] == word.charAt(index))
            dfs(board, word, row, col+1, index+1, 3);
        if(row < board.length-1 && flag != 4 && board[row+1][col] == word.charAt(index))
            dfs(board, word, row+1, col, index+1, 1);
        return false;
    }

    public static void main(String[] args){
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        exist(board, word);
    }
}
