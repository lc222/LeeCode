package Dynamic_Programming;

import java.util.Arrays;

/**
 413. Arithmetic Slices

 A sequence of number is called arithmetic if it consists of at least three elements and if the difference between

 any two consecutive elements is the same.

 For example, these are arithmetic sequence:

 1, 3, 5, 7, 9
 7, 7, 7, 7
 3, -1, -5, -9
 The following sequence is not arithmetic.

 1, 1, 2, 5, 7

 A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such

 that 0 <= P < Q < N.

 A slice (P, Q) of array A is called arithmetic if the sequence:
 A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

 The function should return the number of arithmetic slices in the array A.


 Example:

 A = [1, 2, 3, 4]

 return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.

 */


public class numberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length <3)
            return 0;
        int [][] dp = new int[A.length][A.length];
        int res=0, count=2, tmp=0, dif=A[1]-A[0];
        for(int i=2; i<A.length; i++){
            if(A[i] - A[i-1] == dif) {
                count++;
                tmp += count-2;
            }
            else{
                res += tmp;
                count = 2;
                tmp = 0;
                dif = A[i] - A[i-1];
            }
        }
        return res+tmp;
    }

    public int numberOfArithmeticSlices1(int[] A) {
        int[] lens = new int[A.length];
        for (int i = 2; i < A.length; ++i)
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1])
                lens[i] = Math.max(1, lens[i - 1] + 1);
        return Arrays.stream(lens).sum();
    }

    //100%，是用最少的变量，进行最少的变量更新和计算，速度最快
    public int numberOfArithmeticSlices2(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
}
