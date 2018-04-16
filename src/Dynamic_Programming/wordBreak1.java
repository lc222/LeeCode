package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

/**
 140. Word Break II
 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct

 a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].

 UPDATE (2017/1/4):
 The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code

 definition to get the latest changes.

 */

public class wordBreak1 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> [] dp = new List[s.length()+1];
        dp[0] = new ArrayList<>();
        for(int i=1; i<=s.length(); i++){
            dp[i] = new ArrayList<>();
            for(int j=0; j<i; j++){
                String ss = s.substring(j, i);
                if(j == 0 && wordDict.contains(ss)){
                        dp[i].add(ss);
                }else if(j > 0 && dp[j].size() > 0 && wordDict.contains(ss)){
                    for(String sss : dp[j])
                        dp[i].add(sss+" " +ss);
                }
            }
        }
        return dp[s.length()];
    }
}
