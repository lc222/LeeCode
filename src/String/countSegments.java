package String;

/**

 434. Number of Segments in a String

 Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

 Please note that the string does not contain any non-printable characters.

 Example:

 Input: "Hello, my name is John"
 Output: 5

 */


public class countSegments {

    //10%
    public static int countSegments(String s) {
        if(s == null || s.equals("") || s.trim().equals(""))
            return 0;
        String[] res = s.trim().split(" +");
        return res.length;
    }

    //28%
    public int countSegments1(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
                res++;
        return res;
    }

    //63%
    public int countSegments2(String s) {
        int segs = 0;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++) {
            if(chars[i]!=' ') segs++;
            while(i<chars.length && chars[i]!=' ') i++;
        }
        return segs;
    }

    public static void main(String[] args){
        System.out.println(countSegments("                "));
        System.out.println("                ".trim());
    }
}
