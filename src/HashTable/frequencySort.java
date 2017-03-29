package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class frequencySort {
	//33%
	public String frequencySort(String s) {
	    if (s == null) {
	        return null;
	    }
	    Map<Character, Integer> map = new HashMap();
	    char[] charArray = s.toCharArray();
	    int max = 0;
	    for (Character c : charArray) {
	        if (!map.containsKey(c)) {
	            map.put(c, 0);
	        }
	        map.put(c, map.get(c) + 1);
	        max = Math.max(max, map.get(c));
	    }

	    List<Character>[] array = buildArray(map, max);

	    return buildString(array);
	}
//92.6%
	public String frequencySort1(String s){
		if(s.length()<3)
			return s;
		int [] map = new int [256];
		int max = 0;
		for(Character c:s.toCharArray()){
			map[c] ++;
			max = Math.max(max, map[c]);
		}
		String[] buckets = new String[max + 1];
		for(int i=0; i<256; i++){
			String str = buckets[map[i]];
			if(map[i] > 0)
				buckets[map[i]] = (str == null)? "" + (char)i : (str + (char)i);
		}
		StringBuilder strb = new StringBuilder();
		for(int i=max; i>=0; i--){
			if(buckets[i] != null)
				for(char c:buckets[i].toCharArray())
					for(int j=0; j<i; j++)
						strb.append(c);
		}
		return strb.toString();
	}
	
	//78%
	public String frequencySort2(String s) {
	    char[] arr = s.toCharArray();
	    
	    // bucket sort
	    int[] count = new int[256];
	    for(char c : arr) count[c]++;
	    
	    // count values and their corresponding letters
	    Map<Integer, List<Character>> map = new HashMap<>();
	    for(int i = 0; i < 256; i++){
	        if(count[i] == 0) continue;
	        int cnt = count[i];
	        if(!map.containsKey(cnt)){
	            map.put(cnt, new ArrayList<Character>());
	        }
	        map.get(cnt).add((char)i);
	    }

	    // loop throught possible count values
	    StringBuilder sb = new StringBuilder();
	    for(int cnt = arr.length; cnt > 0; cnt--){ 
	        if(!map.containsKey(cnt)) continue;
	        List<Character> list = map.get(cnt);
	        for(Character c: list){
	            for(int i = 0; i < cnt; i++){
	                sb.append(c);
	            }
	        }
	    }
	    return sb.toString();
	}
	
	private List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) {
	    List<Character>[] array = new List[maxCount + 1];
	    for (Character c : map.keySet()) {
	        int count = map.get(c);
	        if (array[count] == null) {
	            array[count] = new ArrayList();
	        }
	        array[count].add(c);
	    }
	    return array;
	}

	private String buildString(List<Character>[] array) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = array.length - 1; i > 0; i--) {
	        List<Character> list = array[i];
	        if (list != null) {
	            for (Character c : list) {
	                for (int j = 0; j < i; j++) {
	                    sb.append(c);
	                }
	            }
	        }
	    }
	    return sb.toString();
	}
}
