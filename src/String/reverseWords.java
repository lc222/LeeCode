package String;

/*

151. Reverse Words in a String

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

 */


public class reverseWords {

    //45%
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        StringBuilder res = new StringBuilder();
        for(int i=words.length - 1; i > 0; i--)
            res.append(words[i] + " ");
        res.append(words[0]);
        return res.toString();
    }

    //83%
    public static String reverseWords1(String s) {
        if (s == null)
            return null;

        char[] str = s.toCharArray();
        int start = 0, end = str.length - 1;

        // Trim start of string
        while (start <= end && str[start] == ' ')
            start++;

        //Trim end of string
        while (end >= 0 && str[end] == ' ')
            end--;

        if (start > end)
            return new String("");

        int i = start;
        while (i <= end) {
            if (str[i] != ' ') {
                // case when i points to a start of word -  find the word reverse it
                int j = i + 1;
                while (j <= end && str[j] != ' ')
                    j++;
                reverse(str, i, j - 1);
                i = j;
            } else {
                if (str[i - 1] == ' ') {
                    //case when prev char is also space - shift char to left by 1 and decrease end pointer
                    int j = i;
                    while (j <= end - 1) {
                        str[j] = str[j + 1];
                        j++;
                    }
                    end--;
                } else
                    // case when there is just single space
                    i++;
            }
        }
        //Now that all words are reversed, time to reverse the entire string pointed by start and end - This step reverses the words in string
        reverse(str, start, end);
        // return new string object pointed by start with len = end -start + 1
        return new String(str, start, end - start + 1);
    }

    private static void reverse(char[] str, int begin, int end) {
        while (begin < end) {
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }
    }
}
