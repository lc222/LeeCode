package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
    	if(s.length() < 2)
    		return s.length();
        int res = 0;
        for(int i=0; i<s.length()-1; i++){
        	Set<Character> map = new HashSet<>();
        	map.add(s.charAt(i));
        	int j = i+1;
        	for(; j<s.length(); j++)
        		if(!map.add(s.charAt(j)))
        			break;
        	res = Math.max(res, j-i);
        }
        return res;
    }
    
    public int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
    
    public static int lengthOfLongestSubstring2(String s) {
        int[] mOccur = new int[256];
        int maxL = 0;
        for(int i = 0, j = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            ++mOccur[ch];
            while(mOccur[ch] > 1){
                --mOccur[s.charAt(j++)];
            }
            maxL = Math.max(maxL, i - j + 1);
        }
        return maxL;
    }
    
	public static void main(String [] args){
		lengthOfLongestSubstring2("abba");
	}
}
