package String;

/**
 686. Repeated String Match

 Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.

 If no such solution, return -1.

 For example, with A = "abcd" and B = "cdabcdab".

 Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A

 repeated two times ("abcdabcd").

 Note:
 The length of A and B will be between 1 and 10000.

 */


public class repeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        StringBuilder res = new StringBuilder(A);
        int count = 1;
        while(res.indexOf(B) < 0){
            if(res.length() - A.length() > B.length()) return -1;
            res.append(A);
            count ++;
        }
        return count;
    }


    //88%
    public int repeatedStringMatch2(String A, String B) {
        if(A.length() > B.length()){
            if(A.contains(B))
                return 1;
            else if((A+A).contains(B))
                return 2;
        }
        StringBuilder res = new StringBuilder(A);
        int count = 1;
        while(res.indexOf(B) < 0){
            if(res.length() > B.length()) return -1;
            res.append(A);
            count ++;
        }
        return count;
    }

    //99%
    public int repeatedStringMatch1(String A, String B) {
        int count = 1;
        int i = 0;
        for (int j = 0; j < B.length(); j++) {
            if (A.charAt(i) != B.charAt(j)) {
                if (count > 1) {       // already second time: no way to make B from A
                    return -1;
                }
                j = -1;    // try to match j's starting character with next i
            }

            i++;
            if (i == A.length()) {        // one more time of A
                if (j == B.length() - 1) {
                    break;
                }
                count++;
                i = 0;
            }
        }
        return count;
    }
}
