package util;

/**
 * @author chenlei
 * @since  2016 - 09 - 04 10:55
 */
public class StringUtils {

    public static boolean isBlank(String string) {
        if(string == null) {
            return true;
        }
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }

    public static void swapChar(char []chars, int first, int second) {
        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;
     }


    public static void reverseCharArray(char []chars, int first, int second) {
        while (first < second) {
            swapChar(chars, first++, second--);
        }
    }

    public static void printStrToHex(String s) {
        for (char c : s.toCharArray()) {
            System.out.print(Integer.toHexString(c));
        }
        System.out.println();
    }

}
