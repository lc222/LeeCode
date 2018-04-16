package Dynamic_Programming;

/**
 304. Range Sum Query 2D - Immutable

 Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner

 (row1, col1) and lower right corner (row2, col2).

 Range Sum Query 2D
 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

 Example:
 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 sumRegion(1, 1, 2, 2) -> 11
 sumRegion(1, 2, 2, 4) -> 12
 Note:
 You may assume that the matrix does not change.
 There are many calls to sumRegion function.
 You may assume that row1 ≤ row2 and col1 ≤ col2.
 */

public class NumMatrix {

    //26%
    int [][] sum = null;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 0)
            return;
        sum = new int [matrix.length+1][matrix[0].length+1];
        for(int i=1; i<matrix.length+1; i++){
            for(int j=1; j<matrix[0].length+1; j++)
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }

//96.28
    private int[][] sumRegion;

//    public NumMatrix1(int[][] matrix) {
//        if (matrix.length != 0)  sumRegion = new int[matrix.length + 1][matrix[0].length + 1];
//
//        for (int i = 0; i < matrix.length; i++) {
//            int sum = 0;
//            for (int j = 0; j < matrix[0].length; j++) {
//                sum += matrix[i][j];
//                sumRegion[i + 1][j + 1] = sum + sumRegion[i][j + 1];
//            }
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        return sumRegion[row2 + 1][col2 + 1] - sumRegion[row1][col2 + 1] - sumRegion[row2 + 1][col1] + sumRegion[row1][col1];
//    }
}
