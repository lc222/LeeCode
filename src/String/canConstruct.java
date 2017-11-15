package String;

/**

 383. Ransom Note

 Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

 Each letter in the magazine string can only be used once in your ransom note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true

 */


public class canConstruct {

    //45%
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;
        int [] count = new int [26];
        for(int i=0; i<magazine.length(); i++){
            if(i<ransomNote.length())
                count[ransomNote.charAt(i)-'a'] ++;
            count[magazine.charAt(i)-'a'] --;
        }

        for(int num : count)
            if(num > 0)
                return false;

        return true;
    }

    //87%
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] table = new int[26];
        for (char c : magazine.toCharArray())   table[c - 'a']++;
        for (char c : ransomNote.toCharArray())
            if (--table[c - 'a'] < 0) return false;
        return true;
    }
}
