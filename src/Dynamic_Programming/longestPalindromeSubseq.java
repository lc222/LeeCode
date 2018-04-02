package Dynamic_Programming;

/**

 516. Longest Palindromic Subsequence

 Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".
 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".


 */



public class longestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        if(s == null || s.equals(""))
            return 0;
        int [][] dp = new int [s.length()][s.length()];
        for(int i=0; i<s.length(); i++)
            dp[i][i] = 1;

        for(int i=s.length()-1; i>=0; i--){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][s.length()-1];
    }

    public int longestPalindromeSubseq1(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0;i < len;i++){
            dp[i][i] = 1;
        }
        //for each interval length
        for(int l = 2;l <= len;l++){
            //for each interval with the same length
            for(int st = 0;st <= len-l;st++){
                int ed = st+l-1;
                //if left end equals to right end or not
                dp[st][ed] = s.charAt(st)==s.charAt(ed)? dp[st+1][ed-1]+2 : Math.max(dp[st+1][ed], dp[st][ed-1]);
            }
        }
        return dp[0][len-1];
    }

    public int help(String s, int [][] a, int i, int j){
        if(i > j || a[i][j] != 0) return a[i][j];
        if(s.charAt(i) == s.charAt(j))
            a[i][j] = help(s, a, i+1, j-1);
        else
            a[i][j] = Math.max(help(s, a, i+1, j), help(s, a, i, j-1));
        return a[i][j];
    }
}
