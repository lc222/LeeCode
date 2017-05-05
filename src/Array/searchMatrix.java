package Array;

/**
 * Created by liuchong on 2017/5/4.
 */
public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix[0].length - 1;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][n] >= target){
                for(int j=0; j<=n; j++){
                    if(matrix[i][j] == target)
                        return true;
                }
                break;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];

            if( mid_value == target){
                return true;

            }else if(mid_value < target){
                //Should move a bit further, otherwise dead loop.
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }
}
