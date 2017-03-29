package HashTable;

import java.util.ArrayList;
import java.util.List;

public class findAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if(s == null || p == null || s.length() < p.length())   return list;
        int lengthp = p.length();
        int lengths = s.length();
        int[] hash = new int[26];
        for(char c : p.toCharArray()){
            ++hash[c - 'a'];
        }
        int left = 0, right = 0;
        while(right < lengths){
            if(hash[s.charAt(right++) - 'a']-- > 0) lengthp--;
            if(lengthp == 0)    list.add(left);
            if(right - left == p.length() && hash[s.charAt(left++) - 'a']++ >= 0)    lengthp++;
        }
        return list;
    }
    
    public boolean isAnagram1(String s, String t) {
        int [] tmp = new int[26];
        for(char c : s.toCharArray())
            tmp[c-'a'] ++;
        for(char c:t.toCharArray())
            tmp[c-'a'] --;
        for(int a:tmp)
            if(a!=0)
                return false;
        return true;
    }
    
	public static void main(String[] args){
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> res = findAnagrams(s, p);
		System.out.println(res);
	}
}
