package String;


/*
125. Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

 */

public class isPalindrome {


    //45%
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char [] res = s.toCharArray();
        int i=0, j=res.length-1;
        while(i <= j){
            while(i<=j && !Character.isLetterOrDigit(res[i])) i++;
            while(i<=j && !Character.isLetterOrDigit(res[j])) j--;
            if(res[i] != res[j])
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }

    //8.8%
    public boolean isPalindrome1(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }


    private static final char[]charMap = new char[256];
    static{
        for(int i=0;i<10;i++){
            charMap[i+'0'] = (char)(1+i);  // numeric
        }
        for(int i=0;i<26;i++){
            charMap[i+'a'] = charMap[i+'A'] = (char)(11+i);  //alphabetic, ignore cases
        }
    }

    //99.5%
    public boolean isPalindrome2(String s) {
        char[]pChars = s.toCharArray();
        int start = 0,end=pChars.length-1;
        char cS,cE;
        while(start<end){
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if(cS!=0 && cE!=0){
                if(cS!=cE)return false;
                start++;
                end--;
            }else{
                if(cS==0)start++;
                if(cE==0)end--;
            }
        }
        return true;
    }

    public static void main(String[] args){

        isPalindrome("A man, a plan, a canal: Panama");
    }
}
