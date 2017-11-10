package String;

/**
 * Created by liuchong on 2017/11/9.

 344. Reverse String

 Write a function that takes a string as input and returns the string reversed.
'
 Example:
 Given s = "hello", return "olleh".

 */
public class reverseString {

    public String reverseString(String s) {
        StringBuilder res = new StringBuilder(s);
        return res.reverse().toString();
    }

    public String reverseString1(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }
}
