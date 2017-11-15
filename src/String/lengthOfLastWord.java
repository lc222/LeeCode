package String;

/**

 58. Length of Last Word

 Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 Example:

 Input: "Hello World"
 Output: 5


 */

public class lengthOfLastWord {

    //59%
    public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }

    //59%
    public int lengthOfLastWord1(String s){
        int count = -1, i = s.length();
        while (--i >= 0 && s.charAt(i) == ' ');
        while (i - ++count >= 0 && s.charAt(i - count) != ' ');
        return count;
    }
}
