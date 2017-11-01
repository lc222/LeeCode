package BinarySearch;

/*
483. Smallest Good Base

For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.

Now given a string representing n, you should return the smallest good base of n in string format.

Example 1:
Input: "13"
Output: "3"
Explanation: 13 base 3 is 111.

Example 2:
Input: "4681"
Output: "8"
Explanation: 4681 base 8 is 11111.

Example 3:
Input: "1000000000000000000"
Output: "999999999999999999"
Explanation: 1000000000000000000 base 999999999999999999 is 11.


Note:
The range of n is [3, 10^18].
The string representing n is always valid and will not have leading zeros.

 */

import java.math.BigInteger;

public class smallestGoodBase {

    public static String smallestGoodBase(String n) {
        long s = Long.parseLong(n);
        for(int max_e=(int)(Math.log(s)/Math.log(2)) + 1; max_e>=2; max_e--){
            long low=2, high=(long)(Math.pow(s, 1.0/max_e) + 1), mid;
            while(low <= high){
                mid = low + (high - low)/2;
                BigInteger left = BigInteger.valueOf(mid);
                left = left.pow(max_e).subtract(BigInteger.ONE);
                BigInteger right = BigInteger.valueOf(s).multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));
                int cmr = left.compareTo(right);
                if(cmr == 0)
                    return String.valueOf(mid);
                else if(cmr > 0)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return String.valueOf(s-1);
    }

    public String smallestGoodBase1(String n) {
//        long num = 0;
//        for (char c : n.toCharArray()) num = num * 10 + c - '0';
        long num = Long.parseLong(n);
        long x = 1;
        for (int p = 64; p >= 1; p--) {
            if ((x << p) < num) {
                long k = helper(num, p);
                if (k != -1) return String.valueOf(k);
            }
        }
        return String.valueOf(num - 1);
    }

    private long helper(long num, int p) {
        long l = 1, r = (long)(Math.pow(num, 1.0/p) + 1);
        while (l < r) {
            long mid = l + (r - l) / 2;
            long sum = 0, cur = 1;
            for (int i = 0; i <= p; i++) {
                sum += cur;
                cur *= mid;
            }
            if (sum == num) return mid;
            else if (sum > num) r = mid;
            else l = mid + 1;
        }
        return -1;
    }

    public String smallestGoodBase2(String n) {
        BigInteger N = new BigInteger(n);
        long base = Long.MAX_VALUE;

        for (int k = 2; k < 66; k++) {

            long l = 2, r = Long.MAX_VALUE - 5;
            while (l <= r) {
                long mid = l + (r - l) / 2;

                BigInteger cb = BigInteger.valueOf(mid).pow(k).subtract(BigInteger.ONE);
                BigInteger wb = N.multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));

                int cmp = cb.compareTo(wb);
                if (cmp == 0) {
                    base = Math.min(base, mid);
                    break;
                } else if (cmp < 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return "" + base;
    }

    public static void main(String[] args){
        String aa = smallestGoodBase("470988884881403701");
        System.out.println(aa);
    }
}
