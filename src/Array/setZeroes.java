package Array;

/**
 * Created by liuchong on 2017/5/5.
 */
public class setZeroes {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[0].length; j++)
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
        for(int i=0; i<matrix.length; i++){
            if(row[i] == 1){
                for(int j=0; j<matrix[0].length; j++)
                    matrix[i][j] = 0;
            }
        }
        for(int i=0; i<matrix[0].length; i++){
            if(col[i] == 1){
                for(int j=0; j<matrix.length; j++)
                    matrix[j][i] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
