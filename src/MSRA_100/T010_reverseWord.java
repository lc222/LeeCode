package MSRA_100;

public class T010_reverseWord {
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
}
