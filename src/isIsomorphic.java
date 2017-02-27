import java.util.HashMap;
import java.util.Map;

public class isIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> tmp = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for(int i=0; i<ss.length; i++)
        {
        	if(tmp.containsKey(ss[i]))
        	{
        		if(tmp.get(ss[i]) == tt[i])
        			continue;
        		else
        			return false;
        	}
        	else
        		if(tmp.containsValue(tt[i]))
        			return false;
        		else
        			tmp.put(ss[i], tt[i]);        		
        }
        return true;
    }
    
    public boolean isIsomorphic2(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }    
}
