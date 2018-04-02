package Dynamic_Programming;

/**

 5. Longest Palindromic Substring

 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.


 Example:

 Input: "cbbd"

 Output: "bb"
 */


public class longestPalindrome {
    public String longestPalindrome(String s) {
        if(s == null || s.equals(""))
            return "";
        char [] ch = s.toCharArray();
        int max = 1, left=0, right=0;
        for(int i=0; i<ch.length; i++){
            for(int j=0; i-j>=0 && i+j<ch.length; j++){
                if(ch[i-j] != ch[i+j]){
                    if(2*j+1 > max){
                        max = 2*j+1;
                        left = i-j;
                        right = i+j;
                    }
                }
                if(ch[i-j] != ch[i+j+1]){
                    if(2*j > max){
                        max = 2*j+1;
                        left = i-j;
                        right = i+j;
                    }
                }
            }
        }
        return s.substring(left, right);
    }
}
