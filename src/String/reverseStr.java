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

 */
public class reverseStr {

    //35%
    public static String reverseStr(String s, int k) {
        char [] res = s.toCharArray();
        int n = s.length()/(2*k), i;
        for(i=0; i<n; i++){
            int left=i*2*k, right=left+k-1;
            while(left < right){
                char tmp = res[left];
                res[left] = res[right];
                res[right] = tmp;
                left ++;
                right --;
            }
        }
        int left=i*2*k, right=Math.min(left+k-1, s.length()-1);
        while(left < right){
            char tmp = res[left];
            res[left] = res[right];
            res[right] = tmp;
            left ++;
            right --;
        }
        return new String(res);
    }


    //44%
    public String reverseStr1(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    //68%
    public String reverseStr2(String s, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % (2 * k) < k) res.insert(i - i % (2 * k), s.charAt(i));
            else res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(reverseStr("abcdefg", 8));
    }
}
