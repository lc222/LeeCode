package String;

/**

 28. Implement strStr()

 Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1

 */


public class strStr {

    //5%
    public int strStr(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        for(int i=0; i<haystack.length(); i++){
            if(haystack.substring(i).startsWith(needle))
                return i;
        }
        return -1;
    }

    //48%
    public static int strStr1(String haystack, String needle){
        if(needle.equals(""))
            return 0;
        for(int i=0; i<=haystack.length() - needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j=1;
                while(j<needle.length() && haystack.charAt(i+j) == needle.charAt(j)) j++;
                if(j == needle.length()) return i;
            }
        }
        return -1;
    }

    public static int strStr4(String haystack, String needle){
        if(needle.equals(""))
            return 0;

        char [] hay = haystack.toCharArray();
        char [] need = needle.toCharArray();
        for(int i=0; i<=haystack.length() - needle.length(); i++){
            if(hay[i] == need[0]){
                int j=1;
                while(j<needle.length() && hay[i+j] == need[j]) j++;
                if(j == needle.length()) return i;
            }
        }
        return -1;
    }

    //28%
    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }


    //KMP方法，20%
    private int[] failureFunction(char[] str) {
        int[] f = new int[str.length+1];
        for (int i = 2; i < f.length; i++) {
            int j = f[i-1];
            while (j > 0 && str[j] != str[i-1]) j = f[j];
            if (j > 0 || str[j] == str[i-1]) f[i] = j+1;
        }
        return f;
    }

    public int strStr3(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() <= haystack.length()) {
            int[] f = failureFunction(needle.toCharArray());
            int i = 0, j = 0;
            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++; j++;
                    if (j == needle.length()) return i-j;
                } else if (j > 0) j = f[j];
                else i++;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        strStr1("abcdefg", "efg");
    }
}
