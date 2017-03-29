package HashTable;

import java.util.HashMap;
import java.util.Map;

public class wordPattern {
    public boolean wordPattern(String pattern, String str) {
    	Map<Character, String> tmp = new HashMap<>();
    	String [] ss = str.split(" ");
    	if(pattern.length() != ss.length)
    		return false;
        for(int i=0; i<pattern.length(); i++)
        {
        	if(tmp.containsKey(pattern.charAt(i))){
        		if(! tmp.get(pattern.charAt(i)).equals(ss[i]))
        			return false;
        	}else if(tmp.containsValue(ss[i]))
        		return false;
        	else
        		tmp.put(pattern.charAt(i), ss[i]);
        }
        return true;
    }
    
    public boolean wordPattern1(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}
