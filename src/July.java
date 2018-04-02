import java.util.Arrays;
import java.util.List;

public class July {
    //1.1 反转字符串
    public String rotateString(String obj, Integer n) {
        if(obj == null || n < 0)
            return "";
        char [] res = obj.toCharArray();
        reverseCharArray(res, 0, n-1);
        reverseCharArray(res, n, res.length-1);
        reverseCharArray(res, 0, res.length-1);
        return String.valueOf(res);
    }

    public void reverseCharArray(char []chars, int first, int second) {
        while(first < second){
            char tmp = chars[first];
            chars[first++] = chars[second];
            chars[second--] = tmp;
        }
    }
    //1.2 字符串包含
    public boolean stringContainByHash(String a, String b) {
        boolean[] array = new boolean[26];
        for(char c : a.toCharArray())
            array[c-'A'] = true;
        for(char c : b.toCharArray()){
            if(!array[c-'A'])
                return false;
        }
        return true;
    }
    // 1.3 字符串全排列
    public void permutationByRecursion(char a[], int i) {
        if(i == a.length-1) {
            System.out.println(String.valueOf(a));
            return;
        }
        for(int j =i; j<a.length; j++){
            reverseCharArray(a, i, j);
            permutationByRecursion(a, i+1);
            reverseCharArray(a, i, j);
        }
    }

    //1.4 字符串转Int，注意溢出
    //题目要求输入为数字的字符串，因此不做其他字符的检测
    public int strToInt(String s) {
        int beginIndex = 0;
        boolean isPositive = true;
        if(s.charAt(0) == '+') {
            beginIndex = 1;
        } else if(s.charAt(0) == '-') {
            beginIndex = 1;
            isPositive = false;
        }
        int result = 0;
        for( ; beginIndex < s.length(); beginIndex++) {
            if(isPositive) {
                if(result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && (s.charAt(beginIndex) - '0') > (Integer.MAX_VALUE  % 10))) {
                    //会溢出
                    return Integer.MAX_VALUE;
                }
            } else {
                if(result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && (s.charAt(beginIndex) - '0') >= (Integer.MAX_VALUE  % 10 + 1))) {
                    //会溢出
                    return Integer.MIN_VALUE;
                }
            }
            result = result * 10 + s.charAt(beginIndex) - '0';
        }
        return isPositive ? result : -result;
    }

    //1.5 回文判断
    public boolean isPalindrome(String str) {
        if(str == null || str.equals(""))
            return false;
        char [] res = str.toCharArray();
        int i=0, j=str.length()-1;
        while(i < j){
            if(res[i++] != res[j--])
                return false;
        }
        return true;
    }

    //1.6 最长回文子串
    public int maxPalindromeLength(String str) {
        if(str == null || str.equals(""))
            return 0;
        char [] ch = str.toCharArray();
        int res = 1;
        for(int i=0; i<ch.length; i++){
            int j=1;
            while(i-j >=0&&i+j<ch.length&&ch[i-j] == ch[i+j])
                j++;
            if(2*j - 1 > res)
                res = 2*j-1;
            j=0;
            while(i-j>=0 && i+j+1 < ch.length && ch[i-j] == ch[i+j+1])
                j++;
        }
        return res;
    }

    //2.1 寻找最小的K个数
    public int findK(int []a, int low, int high, int k) {
        int tmp = a[low];
        while(low < high) {
            while (low < high && a[high] >= tmp) high--;
            if (low < high) a[low] = a[high];
            while (low < high && a[low] <= tmp) low++;
            if (low < high) a[high] = a[low];
        }
        a[low] = tmp;
        return low;
    }

    //2.2 TwoSum
    public void findTheSumOfTwo(int a[], int sum) {
        Arrays.sort(a);
        int start=0, end = a.length-1;
        while(start < end){
            if(a[start] + a[end] == sum)
                return;
            else if(a[start] + a[end] > sum)
                end--;
            else
                start++;
        }
    }
    //2.3 寻找和为定值的多个数
    public void findTheSumOfMany(int n, int target, int i, List<Integer> list) {
        int [] dp = new int[n];

    }
}
