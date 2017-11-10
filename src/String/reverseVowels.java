package String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liuchong on 2017/11/9.

 345. Reverse Vowels of a String

 Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y"

 */
public class reverseVowels {

    //18%
    public String reverseVowels(String s) {
        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){

            while(start<end && !vowels.contains(chars[start]+"")){
                start++;
            }

            while(start<end && !vowels.contains(chars[end]+"")){
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }

    //55%
    public String reverseVowels1(String s) {
        char[] list=s.toCharArray();
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for (int i=0, j=list.length-1; i<j; ) {
            if (!set.contains(list[i])) {
                i++;
                continue;
            }
            if (!set.contains(list[j])) {
                j--;
                continue;
            }
            char temp=list[i];
            list[i]=list[j];
            list[j]=temp;
            i++;
            j--;
        }
        return String.valueOf(list);
    }

    public static boolean isVowel(char a){
        switch(a){
            case ('a') : return true;
            case ('e') : return true;
            case ('i') : return true;
            case ('o') : return true;
            case ('u') : return true;
            case ('A') : return true;
            case ('E') : return true;
            case ('I') : return true;
            case ('O') : return true;
            case ('U') : return true;
            default : return false;
        }
    }

    //99%
    public static String reverseVowels2(String s) {
        if (s.length()<2) return s;

        char[] tab = s.toCharArray();
        int j = tab.length - 1;
        int i = 0;

        while( i < j ) {

            if (!isVowel(tab[i]))
                i++;
            else {
                while (j!=i && !isVowel(tab[j]))
                    j--;

                char temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
                i++;
                j--;
            }
        }
        return new String(tab);
    }
}
