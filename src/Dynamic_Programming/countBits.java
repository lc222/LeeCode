package Dynamic_Programming;

/**

 338. Counting Bits

 Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in

 their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n)

 /possibly in a single pass?
 Space complexity should be O(n).
 Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.


 */


public class countBits {
    //80%
    public int[] countBits(int num) {
        /**
         Obviously, this is overlap sub problem, and we can come up the DP solution. For now, we need find the function to implement DP.

         dp[0] = 0;

         dp[1] = dp[0] + 1;

         dp[2] = dp[0] + 1;

         dp[3] = dp[1] +1;

         dp[4] = dp[0] + 1;

         dp[5] = dp[1] + 1;

         dp[6] = dp[2] + 1;

         dp[7] = dp[3] + 1;

         dp[8] = dp[0] + 1;
         …

         This is the function we get, now we need find the other pattern for the function to get the general function.

         After we analyze the above function, we can get
         dp[0] = 0;

         dp[1] = dp[1-1] + 1;

         dp[2] = dp[2-2] + 1;

         dp[3] = dp[3-2] +1;

         dp[4] = dp[4-4] + 1;

         dp[5] = dp[5-4] + 1;

         dp[6] = dp[6-4] + 1;

         dp[7] = dp[7-4] + 1;

         dp[8] = dp[8-8] + 1;
         …

         Obviously, we can find the pattern for above example, so now we get the general function

         dp[index] = dp[index - offset] + 1;

         Coding:
         */
        int result[] = new int[num + 1];
        int offset = 1;
        for (int index = 1; index < num + 1; ++index){
            if (offset * 2 == index){
                offset *= 2;
            }
            result[index] = result[index - offset] + 1;
        }
        return result;
    }

    //100%
    public int[] countBits1(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
