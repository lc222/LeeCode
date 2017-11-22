package String;

/**

 8. String to Integer (atoi)

 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself

 what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to

 gather all the input requirements up front.

 Update (2015-02-10):
 The signature of the C++ function had been updated. If you still see your function signature accepts a const char *

 argument, please click the reload button  to reset your code definition.

 spoilers alert... click to show requirements for atoi.

 */

public class myAtoi {

    //45%
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;//
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) sum * sign;
    }


    //72%
    public int myAtoi1(String str) {
        str = str.trim();
        if (str.isEmpty())
            return 0;
        int sign = 1; int i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+'){
            sign = (str.charAt(0) == '-')? -1 : 1;
            if (str.length() < 2 || !Character.isDigit(str.charAt(1))) {
                return 0;
            }
            i++;
        }
        int n = 0;
        while (i < str.length()) {
            if (Character.isDigit(str.charAt(i))) {
                int d = str.charAt(i) - '0';
                if (n > (Integer.MAX_VALUE - d) / 10) { //Detect the integer overflow.
                    n = (sign == -1)? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    return n;
                }
                n = n*10 + d;
            } else {
                break;
            }
            i++;
        }
        return sign * n;
    }
}
