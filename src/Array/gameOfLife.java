package Array;

/**
 * Created by liuchong on 2017/4/19.
 */
public class gameOfLife {
    public void gameOfLife(int[][] board) {
        //int[][] tmp = new int [board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int count = count(board, i, j);
                if(board[i][j] == 1) {
                    if (count == 2 || count == 3)
                        board[i][j] = 3;
                }else{
                    if(count == 3)
                        board[i][j] = 2;
                }
            }
        }

        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[0].length; j++){
                board[i][j] >>= 1;
            }
    }

    public int count(int[][] board, int row, int col){
        int sum = 0;
        for(int i = row-1; i<=row+1; i++)
            for(int j = col-1; j<=col+1; j++)
                if(i>=0 && i<board.length && j>=0 && j<board[0].length)
                    sum += board[i][j] & 1;
        sum -= board[row][col] & 1;
        return sum;
    }

    public void gameOfLife1(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countLive = 0;
                for (int p = Math.max(i-1,0); p < Math.min(i+2,m); p++) {
                    for (int q = Math.max(j-1,0); q < Math.min(j+2,n); q++) {
                        if (board[p][q]==2||board[p][q]==1) countLive++;//count status 0 is live
                    }
                }
                countLive -= board[i][j];
                if (board[i][j] == 0 && countLive == 3) board[i][j] = 3; //status 0 is dead,next status is live
                if (board[i][j] == 1 && (countLive < 2 || countLive > 3)) board[i][j] = 2; //status 0 is live,next status is dead

            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
