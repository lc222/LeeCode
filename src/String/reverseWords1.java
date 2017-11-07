package String;

/*

557. Reverse Words in a String III

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving

whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.

 */


public class reverseWords1 {

    //35%
    public static String reverseWords(String s) {
        if(s.equals("") || s.equals(" "))
            return s;
        char[] ss = s.toCharArray();
        int i = 0, j;
        StringBuilder res = new StringBuilder();
        while(i<ss.length){
            j=i;
            while(j < ss.length && ss[j] != ' ') j++;
            res.append(reverse(ss, i, j-1));
            res.append(" ");
            i=j+1;
        }
        res.deleteCharAt(ss.length);
        return res.toString();
    }

    public static String reverse(char[] ss, int i, int j){
        String res = "";
        for(int k=j; k>=i; k--)
            res += ss[k];
        return res;
    }


    //60%
    public String reverseWords1(String s) {
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) str[i] = new StringBuilder(str[i]).reverse().toString();
        StringBuilder result = new StringBuilder();
        for (String st : str) result.append(st + " ");
        return result.toString().trim();
    }

    public static void main(String[] args){
        reverseWords("Let's take LeetCode contest");
    }

}
