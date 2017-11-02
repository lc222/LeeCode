package BinarySearch;

/*

668. Kth Smallest Number in Multiplication Table

Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly from the multiplication table?

Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return the k-th smallest number in this table.

Example 1:
Input: m = 3, n = 3, k = 5
Output:
Explanation:
The Multiplication Table:
1	2	3
2	4	6
3	6	9

The 5-th smallest number is 3 (1, 2, 2, 3, 3).
Example 2:
Input: m = 2, n = 3, k = 6
Output:
Explanation:
The Multiplication Table:
1	2	3
2	4	6

The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
Note:
The m and n will be in the range [1, 30000].
The k will be in the range [1, m * n]

 */

public class findKthNumber {

    public static int findKthNumber(int m, int n, int k) {
        int left=1, right = m*n, mid;
        while(left <= right){
            mid = left + (right-left)/2;
            int count=0, j=n;
            for(int i=1; i<=m; i++){
                while(j >= 1 && i*j > mid) j--;
                count += j;
            }
            if(count < k)left = mid+1;
            else right = mid - 1;
        }
        return left;
    }

    public int findKthNumber1(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = helper(m, n, mid);
            if (count >= k) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    private int helper(int m, int n, int num) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(num / i, n);
        }
        return count;
    }

    public static void main(String[] args){
        int res = findKthNumber(3, 3, 5);
    }
}
