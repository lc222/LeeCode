package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findSubstring {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || words.length == 0)
        	return res;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        	map.put(words[i], map.getOrDefault(words[i], 0)+1);
        int len = words[0].length();
        int length = s.length() - words.length * len;
        for(int i=0; i<=length; i++){
        	if(dfs(s, (Map)map.clone(), i, len))
        		res.add(i);        	
        }
        return res;
    }
    
    public static boolean dfs(String s, Map<String, Integer> map, int start_idx, int len){
    	if(map.isEmpty())
    		return true;
    	String ss = s.substring(start_idx, start_idx+len);
    	if(map.containsKey(ss)){
    		int count = map.get(ss);
    		count --;
    		if(count == 0)
    			map.remove(ss);
    		else
    			map.put(ss, count);
    		return dfs(s, map, start_idx+len, len);
    	}
    	return false;
    }
    
    public static List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words == null || words.length == 0 || s.length() == 0) return res;
        int wordLen = words[0].length();
        int numWord = words.length;
        int windowLen = wordLen * numWord;
        int sLen = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        for(int i = 0; i < wordLen; i++) {  // Run wordLen scans
            HashMap<String, Integer> curMap = new HashMap<>();
            for(int j = i, count = 0, start = i; j + wordLen <= sLen; j += wordLen) {  // Move window in step of wordLen
                // count: number of exceeded occurences in current window
                // start: start index of current window of size windowLen
                if(start + windowLen > sLen) break;
                String word = s.substring(j, j + wordLen);
                if(!map.containsKey(word)) {
                    curMap.clear();
                    count = 0;
                    start = j + wordLen;
                }
                else {
                    if(j == start + windowLen) { // Remove previous word of current window
                        String preWord = s.substring(start, start + wordLen);
                        start += wordLen;
                        int val = curMap.get(preWord);
                        if(val == 1) curMap.remove(preWord);
                        else curMap.put(preWord, val - 1);
                        if(val - 1 >= map.get(preWord)) count--;  // Reduce count of exceeded word
                    }
                    // Add new word
                    curMap.put(word, curMap.getOrDefault(word, 0) + 1);
                    if(curMap.get(word) > map.get(word)) count++;  // More than expected, increase count
                    // Check if current window valid
                    if(count == 0 && start + windowLen == j + wordLen) {
                        res.add(start);
                    }
                }
            }
        }
        return res;
    }

    public static List<Integer> findSubstring2(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return res;
        int len = L[0].length(); // length of each word
        
        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        
        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) { // checkc if match
                String str = S.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in L
            }
        }
        return res;
    }
    
    public static void main(String [] args){
    	String s = "wordgoodgoodgoodbestword";
    	String[] words = {"word", "good", "best", "good"};
    	findSubstring1(s, words);
    }
}
