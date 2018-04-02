package String;

/**

 583. Delete Operation for Two Strings

 Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in

 each step you can delete one character in either string.

 Example 1:
 Input: "sea", "eat"
 Output: 2
 Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 Note:
 The length of given words won't exceed 500.
 Characters in given words can only be lower-case letters.

 */


public class minDistance {

    //6%
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;

        // dp[i][j] stands for distance of first i chars of word1 and first j chars of word2
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
            dp[i][0] = i;
        for (int j = 0; j <= len2; j++)
            dp[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1), dp[i][j - 1] + 1);
            }
        }

        return dp[len1][len2];
    }

    //33%
    public int minDistance1(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i <= word1.length(); i++) {
            for(int j = 0; j <= word2.length(); j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ? dp[i-1][j-1] + 1
                        : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int val =  dp[word1.length()][word2.length()];
        return word1.length() - val + word2.length() - val;
    }

    //63%
    public int minDistance2(String word1, String word2) {
        int n = word1.length() < word2.length() ? word1.length() : word2.length();
        int[] counts = new int[n + 1];
        counts[0] = -1;
        int maxCount = 0;

        for(int i = 0; i < word1.length(); i++){
            for(int t = maxCount + 1; t > 0; t--){
                int start = counts[t - 1] + 1;
                int end = -1;
                if(t == maxCount + 1)
                    end = word2.length();
                else
                    end = counts[t];

                for(int j = start; j < end; j++){
                    if(word1.charAt(i) == word2.charAt(j)){
                        counts[t] = j;

                        if(t == maxCount + 1)
                            maxCount++;

                        break;
                    }
                }
            }

            if(maxCount == n)
                break;
        }

        return word1.length() + word2.length() - 2 * maxCount;
    }
}
