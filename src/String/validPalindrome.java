package String;

/*

680. Valid Palindrome II

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.


 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class validPalindrome {

    public boolean validPalindrome(String s) {
        for(int i=0; i<s.length(); i++){
            String ss = s.substring(0,i) + s.substring(i+1);
            if(isPalindorme(ss))
                return true;
        }
        return false;
    }

    public boolean isPalindorme(String s){
        char [] res = s.toCharArray();
        int start=0, end=s.length()-1;
        while(start <= end){
            if(res[start] != res[end])
                return false;
            else{
                start ++;
                end --;
            }
        }return true;
    }

    public boolean validPalindrome1(String s) {
        char[] res = s.toCharArray();
        int l = -1, r = s.length();
        while (++l < --r)
            if (res[l] != res[r]) return isPalindromic(res, l, r+1) || isPalindromic(res, l-1, r);
        return true;
    }

    public boolean isPalindromic(char[] res, int l, int r) {
        while (++l < --r)
            if (res[l] != res[r]) return false;
        return true;
    }
}
