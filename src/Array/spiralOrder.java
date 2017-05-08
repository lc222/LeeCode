package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuchong on 2017/5/5.
 */
public class spiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length ==0 || matrix[0].length==0)
            return res;
        int row=matrix.length, col=matrix[0].length, n=Math.min(row/2, col/2), i;
        for(i=0; i<n; i++){
            for(int j=i; j<col-i; j++)
                res.add(matrix[i][j]);
            for(int j=i+1; j<row-i-1; j++)
                res.add(matrix[j][col-i-1]);
            for(int j=i; j<col-i; j++)
                res.add(matrix[row-i-1][col-j-1]);
            for(int j=i+1; j<row-i-1; j++)
                res.add(matrix[row-j-1][i]);
        }
        if(row >= col && col%2 != 0)
            for(int j=i; j<row-i; j++)
                res.add(matrix[j][col/2]);
        if(col>row && row%2 != 0)
            for(int j=i; j<col-i; j++)
                res.add(matrix[row/2][j]);
        return res;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return spiralList;

        // declare indices
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true){
            // 1. print top row
            for(int j=left; j <=right;j++){
                spiralList.add(matrix[top][j]);
            }
            top++;
            if(boundriesCrossed(left,right,bottom,top))
                break;

            // 2. print rightmost column
            for(int i=top; i <= bottom; i++){
                spiralList.add(matrix[i][right]);
            }
            right--;
            if(boundriesCrossed(left,right,bottom,top))
                break;

            // 3. print bottom row
            for(int j=right; j >=left; j--){
                spiralList.add(matrix[bottom][j]);
            }
            bottom--;
            if(boundriesCrossed(left,right,bottom,top))
                break;

            // 4. print leftmost column
            for(int i=bottom; i >= top; i--){
                spiralList.add(matrix[i][left]);
            }
            left++;
            if(boundriesCrossed(left,right,bottom,top))
                break;
        }// end while true

        return spiralList;
    }

    private boolean boundriesCrossed(int left,int right,int bottom,int top){
        if(left>right || bottom<top)
            return true;
        else
            return false;
    }

    public static void main(String [] args){
        int[][] matrix = {{1,2,3,4,5}, {4,5,6,4,5}, {7,8,9,4,5}, {1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}};
        spiralOrder(matrix);
    }
}
