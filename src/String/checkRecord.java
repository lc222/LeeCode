package String;


/*

551. Student Attendance Record I

You are given a string representing an attendance record for a student. The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False

 */

public class checkRecord {

    public static boolean checkRecord(String s) {
        char [] res = s.toCharArray();
        int a=0, l=0;
        for(int i=0; i<res.length; i++){
            if(res[i] == 'A') {
                if (a++ > 0)
                    return false;
            }else if(res[i] == 'L'){
                if(res[i+1] == 'L' && res[i+2] == 'L')
                    return false;
            }
        }
        return true;
    }

    public boolean checkRecord1(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }

    public boolean checkRecord2(String s) {
        return !s.contains("LLL") && (s.indexOf("A") == s.lastIndexOf("A"));
    }

    public static void main(String [] args){
        checkRecord("LALL");
    }
}
