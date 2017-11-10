package String;

/**
 * Created by liuchong on 2017/11/9.

 541. Reverse String II

 Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the

 start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but

 greater than or equal to k characters, then reverse the first k characters and left the other as original.

 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"
 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]

 13. Roman to Integer
 没什么点，遍历字符串结合罗马数字表示方法即可

 14. Longest Common Prefix
 首先可以使用便利的方法两两比较得到最长公共子串
 其次可以使用startsWith函数判断，然后将min逐渐变短
 最后可以将数组排序，直接比较第一个和最后一个即可

 20. Valid Parentheses
 判断(){}[]关闭顺序是否正确。使用栈或者用一个数组来保存未关闭的符号

 */
public class reverseStr {

    public static String reverseStr(String s, int k) {
        char [] res = s.toCharArray();
        int n = s.length()/(2*k);
        for(int i=0; i<n; i++){
            int left=i*2*k, right=i*n+k-1;
            while(left < right){
                char tmp = res[left];
                res[left] = res[right];
                res[right] = tmp;
                left ++;
                right --;
            }
        }
        if(s.length() - n*2*k > k){

        }
        return new String(res);
    }

    public static void main(String[] args){
        reverseStr("abcdefgfvde", 2);
    }
}
