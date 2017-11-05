package String;

/*

696. Count Binary Substrings

Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,

and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's:

"0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
Note:

s.length will be between 1 and 50,000.
s will only consist of "0" or "1" characters.

 */

public class countBinarySubstrings {

    public static int countBinarySubstrings(String s) {
        int res = 0;
        for(int i=0; i<s.length(); i++){
            int count=0, j;
            boolean flag = false;
            for(j=i; j<s.length()-1; j++) {
                if (!flag) {
                    if (s.charAt(j) == s.charAt(j + 1))
                        count++;
                    else {
                        flag = true;
                        count++;
                    }
                }else{
                    if(s.charAt(j) == s.charAt(j+1)) {
                        count--;
                        if(count == 0)break;
                    }
                    else {
                        count --;
                        break;
                    }
                }
            }

            if(count == 0 && flag)
                res++;

            if(flag && j == s.length()-1 && count == 1)
                res ++;

        }
        return res;
    }

    //48%
    public static int countBinarySubstrings1(String s){
        int [] count = new int[s.length()];
        int tmp = 0;
        for(int i=0; i<s.length()-1; i++){
            count[tmp] ++;
            if(s.charAt(i) != s.charAt(i+1))
                tmp ++;
        }
        if(s.length() > 1 && s.charAt(s.length()-1) == s.charAt(s.length()-2))
            count[tmp] ++;
        else
            count[tmp] ++;

        int res = 0;
        for(int i=0; i<tmp; i++){
            res += Math.min(count[i], count[i+1]);
        }
        return res;
    }

    //85%
    public static int countBinarySubstrings5(String s){
        int len=s.length();
        if(len<=1) return 0;
        char[] sc= s.toCharArray();
        int [] count = new int[len];
        int tmp = 0;
        for(int i=0; i<len-1; i++){
            count[tmp] ++;
            if(sc[i] != sc[i+1])
                tmp ++;
        }
        if(sc[len-1] == sc[len-2])
            count[tmp] ++;
        else
            count[tmp] ++;

        int res = 0;
        for(int i=0; i<tmp; i++){
            res += Math.min(count[i], count[i+1]);
        }
        return res;
    }

    //94%
    public int countBinarySubstrings2(String s) {
        int len=s.length();
        if(len<=1) return 0;
        char[] sc= s.toCharArray();
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i=1;i<len;i++) {
            if (sc[i] == sc[i-1]) curRunLength++;
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) res++;
        }
        return res;
    }


    public int countBinarySubstrings3(String s) {
        int len=s.length();
        if(len<=1) return 0;
        char[] sc= s.toCharArray();
        int i=0,prev=-1,res=0;
        while(i<len){
            int j=i;
            char c=sc[i];
            while(i<len && sc[i]==c) i++;
            int cur=i-j;
            if(prev!=-1) res+=Math.min(prev,cur);
            prev=cur;
        }
        return res;
    }

    public static void main(String[] args){
        countBinarySubstrings1("10101");
    }
}
