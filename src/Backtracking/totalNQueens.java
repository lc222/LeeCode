package Backtracking;

import java.util.Arrays;
import java.util.List;

/**
 52. N-Queens II

 Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.
 */

public class totalNQueens {
    int res;
    public int totalNQueens(int n) {
        boolean[]
                //ocp0 = new boolean[n], //whether there's a queen ocupying nth row, I don't need it
                ocp90 = new boolean[n], //whether there's a queen ocupying nth column
                ocp45 = new boolean[2 * n - 1], // mark 45 degree occupation
                ocp135 = new boolean[2 * n - 1]; // mark 135 degree occupation
        char[][] map = new char[n][n];
        for (char[] tmp : map) Arrays.fill(tmp, '.'); //init
        solve(0, n, map, ocp45, ocp90, ocp135);
        return res;
    }

    private void solve(int depth, int n, char[][] map, boolean[] ocp45, boolean[] ocp90, boolean[] ocp135) {
        if (depth == n) {
            res ++;
            return;
        }

        for (int j = 0; j < n; j++)
            if (!ocp90[j] && !ocp45[depth + j] && !ocp135[j - depth + n - 1]) {
                ocp90[j] = true;
                ocp45[depth + j] = true;
                ocp135[j - depth + n - 1] = true;
                map[depth][j] = 'Q';
                solve(depth + 1, n, map, ocp45, ocp90, ocp135);
                ocp90[j] = false;
                ocp45[depth + j] = false;
                ocp135[j - depth + n - 1] = false;
                map[depth][j] = '.';
            }
    }

    /*
    常规n-queens解法, 数答案个数.
    用column标记此行之前的哪些column已经放置了queen. 棋盘坐标(row, col)对应column的第col位(LSB --> MSB, 下同).
    用diag标记此位置之前的哪些主对角线已经放置了queen. 棋盘坐标(row, col)对应diag的第(n - 1 + row - col)位.
    用antiDiag标记此位置之前的哪些副对角线已经放置了queen. 棋盘坐标(row, col)对应antiDiag的第(row + col)位.
*/
        int count = 0;

        public int totalNQueens1(int n) {
            dfs(0, n, 0, 0, 0);
            return count;
        }

        private void dfs(int row, int n, int column, int diag, int antiDiag) {
            if (row == n) {
                ++count;
                return;
            }
            for (int i = 0; i < n; ++i) {
                boolean isColSafe = ((1 << i) & column) == 0;
                boolean isDiagSafe = ((1 << (n - 1 + row - i)) & diag) == 0;
                boolean isAntiDiagSafe = ((1 << (row + i)) & antiDiag) == 0;
                if (isColSafe && isDiagSafe && isAntiDiagSafe) {
                    dfs(row + 1, n, (1 << i) | column, (1 << (n - 1 + row - i)) | diag, (1 << (row + i)) | antiDiag);
                }
            }
        }

}
