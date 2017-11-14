package String;

/**
 459. Repeated Substring Pattern

 Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of

 the substring together. You may assume the given string consists of lowercase English letters only and its length

 will not exceed 10000.

 Example 1:
 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.
 Example 2:
 Input: "aba"

 Output: False
 Example 3:
 Input: "abcabcabcabc"

 Output: True

 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

 */

public class repeatedSubstringPattern {

    //80%
    public static boolean repeatedSubstringPattern(String s) {

        int len = s.length();
        for(int i=2; i<=len; i++){
            if(len%i == 0){
                int count = len / i, j;
                for(j=0; j<i-1; j++){
                    if(!s.substring(j*count, (j+1)*count).equals(s.substring((j+1)*count, (j+2)*count)))
                        break;
                }
                if(j == i-1)
                    return true;
            }
        }
        return false;
    }

    //37%
    public boolean repeatedSubstringPattern2(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }

    //14%
    public boolean repeatedSubstringPattern1(String str) {
        if(str == null || str.length() < 2) return false;

        boolean result = false;
        for(int i = 1; i <= str.length()/2; i++) {
            if(str.length()%i != 0) continue;
            String regex = "("+str.substring(0,i)+")" + "+";
            result = result | str.matches(regex);
        }
        return result;
    }

    //88%
    public boolean repeatedSubstringPattern3(String str) {
        //This is the kmp issue
        int[] prefix = kmp(str);
        int len = prefix[str.length()-1];
        int n = str.length();
        return (len > 0 && n%(n-len) == 0);
    }

    private int[] kmp(String s){
        int len = s.length();
        int[] res = new int[len];
        char[] ch = s.toCharArray();
        int i = 0, j = 1;
        res[0] = 0;
        while(i < ch.length && j < ch.length){
            if(ch[j] == ch[i]){
                res[j] = i+1;
                i++;
                j++;
            }else{
                if(i == 0){
                    res[j] = 0;
                    j++;
                }else{
                    i = res[i-1];
                }
            }
        }
        return res;
    }

    public static void main(String [] args){
        System.out.println(repeatedSubstringPattern("bb"));
    }
}
