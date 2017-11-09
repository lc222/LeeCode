package String;

import java.util.Arrays;

/**
 * Created by liuchong on 2017/11/9.

 14. Longest Common Prefix

 Write a function to find the longest common prefix string amongst an array of strings.

 */
public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        String min = strs[0];
        for(int i=1; i<strs.length; i++){
            int len = Math.min(min.length(), strs[i].length());
            min = min.substring(0, len);
            for(int j=0; j<len; j++){
                if(min.charAt(j) != strs[i].charAt(j)) {
                    min = min.substring(0, j);
                    break;
                }
            }

        }
        return min;
    }

    public String longestCommonPrefix1(String[] strs) {
        int n=strs.length;
        if(n==0) return "";
        StringBuilder st=new StringBuilder(strs[0]);
        for(int i=1;i<n;i++){
            while(!strs[i].startsWith(st.toString())) st.deleteCharAt(st.length()-1);
        }
        return st.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs != null && strs.length > 0) {

            Arrays.sort(strs);

            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();

            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    result.append(b[i]);
                } else {
                    return result.toString();
                }
            }
            return result.toString();
        } else
            return "";

    }


    public static void main(String[] args){
        String[] strs = {"aa", "a"};
        longestCommonPrefix(strs);
    }
}
