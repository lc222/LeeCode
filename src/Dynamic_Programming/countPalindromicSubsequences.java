package Dynamic_Programming;

/**
 730. Count Different Palindromic Subsequences

 Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.

 A subsequence of a string S is obtained by deleting 0 or more characters from S.

 A sequence is palindromic if it is equal to the sequence reversed.

 Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.

 Example 1:
 Input:
 S = 'bccb'
 Output: 6
 Explanation:
 The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
 Note that 'bcb' is counted only once, even though it occurs twice.
 Example 2:
 Input:
 S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 Output: 104860361
 Explanation:
 There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
 Note:

 The length of S will be in the range [1, 1000].
 Each character S[i] will be in the set {'a', 'b', 'c', 'd'}.


 */

public class countPalindromicSubsequences {
    public int countPalindromicSubsequences(String S) {
        if(S == null || S.equals(""))
            return 0;
        char [] ch = S.toCharArray();
        int [][] dp = new int[ch.length][ch.length];
        for(int i=ch.length-1; i>=0; i--){
            dp[i][i] = 1;
            for(int j=i+1; j<ch.length; j++){
                if(ch[i] == ch[j]){
                    dp[i][j] = (2 * dp[i + 1][j - 1]);
                    int lo = i+1, hi = j-1;
                    while(lo <= hi && ch[i] != ch[lo]) lo++;
                    while(lo <= hi && ch[i] != ch[hi]) hi--;
                    if(lo > hi)
                        dp[i][j] += 2;
                    else if(lo == hi)
                        dp[i][j] += 1;
                    else
                        dp[i][j] -= dp[lo + 1][hi - 1];
                }else
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
            }
        }
        return dp[0][ch.length - 1];
    }
}
