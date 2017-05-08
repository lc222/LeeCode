package Array;


/**
 * Created by liuchong on 2017/5/5.
 */
public class generateMatrix {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        int count=1;
        for(int i=0; i<n/2; i++){
            for(int j=i; j<n-i; j++)
                res[i][j] = count++;
            for(int j=i+1; j<n-i-1; j++)
                res[j][n-i-1] = count++;
            for(int j=i; j<n-i; j++)
                res[n-i-1][n-j-1] = count++;
            for(int j=i+1; j<n-i-1; j++)
                res[n-j-1][i] = count++;
        }
        if(n%2 != 0)
            res[n/2][n/2] = n*n;
        return res;
    }

    public static int[][] generateMatrix1(int n) {
        int[][] ret = new int[n][n];
        int left = 0, top = 0;
        int right = n - 1, down = n - 1;
        int count = 1;
        while (left <= right) {
            for (int j = left; j <= right; j++) {
                ret[top][j] = count++;
            }
            top++;
            for (int i = top; i <= down; i++) {
                ret[i][right] = count++;
            }
            right--;
            for (int j = right; j >= left; j--) {
                ret[down][j] = count++;
            }
            down--;
            for (int i = down; i >= top; i--) {
                ret[i][left] = count++;
            }
            left++;
        }
        return ret;
    }
    }
