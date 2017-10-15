package BinarySearch;

/**
 * Created by liuchong on 2017/10/13.

 74. Search a 2D Matrix

 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.

 */
public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int left = 0, right = matrix.length*matrix[0].length-1, num = matrix[0].length, mid;
        while(left <= right){
            mid = (left + right)/2;
            if(matrix[mid/num][mid%num] == target)
                return true;
            else if(matrix[mid/num][mid%num] > target)
                right = mid - 1;
            else
                left = mid + 1;

        }
        return false;
    }

    //还可以先遍历每行第一个元素，找到第一个比target大的，说明再起上一行。然后再遍历改行即可。
}
