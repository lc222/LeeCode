package String;

/**
 6. ZigZag Conversion

 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 */

public class convert {

    //35%
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }


    //94%
    public String convert1(String s, int numRows) {
        if(numRows==1) return s;
        int x = 2 * (numRows-1); // distance between pipes |/|/|...
        int len = s.length();
        char[] c = new char[len];
        int k =0;
        for(int i=0; i < numRows; i++)
        {
            for(int j=i;j<len;j=j+x)
            {
                c[k++] = s.charAt(j);
                if(i>0 && i<numRows-1 && j+x-2*i < len)
                {
                    c[k++] = s.charAt(j+x-2*i); // extra character between pipes
                }
            }
        }
        return new String(c);
    }
}
