package String;

/**

38. Count and Say

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

 */


public class countAndSay {

    //65%
    public String countAndSay(int n) {
        StringBuilder curr=new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i=1;i<n;i++){
            prev=curr;
            curr=new StringBuilder();
            count=1;
            say=prev.charAt(0);

            for (int j=1,len=prev.length();j<len;j++){
                if (prev.charAt(j)!=say){
                    curr.append(count).append(say);
                    count=1;
                    say=prev.charAt(j);
                }
                else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();

    }

    //85%
    public String countAndSay1(int n) {
        String ret = ""+1;

        while(--n  > 0)
            ret = apply(ret);

        return ret;
    }

    String apply(String s){
        StringBuilder ret = new StringBuilder();

        for(int i = 0, count =0; i  < s.length() ; ){
            while(i + count < s.length() && s.charAt(i) == s.charAt(i + count))
                count ++;

            ret.append(count).append(s.charAt(i));
            i += count;
            count = 0;
        }

        return ret.toString();
    }
}
