import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class findRepeatedDnaSequences {
    public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> res = new ArrayList<>();
    	Map<String, Integer> tmp = new HashMap<>();
        for(int i=0; i<=s.length()-10; i++){
        	String ss = s.substring(i, i+10);
        	if(tmp.containsKey(ss)){
        		if(tmp.get(ss) == 1)
        			res.add(ss);
        		tmp.put(ss, tmp.get(ss)+1);
        	}else
        		tmp.put(ss, 1);
        }
        return res;
    }
    
    //92%
    public static List<String> findRepeatedDnaSequences1(String s) {
    	Set<String> tmp = new HashSet<>();
    	Set<String> res = new HashSet<>();
    	List<String> rr = new ArrayList<>();
    	for(int i=0; i<s.length()-9; i++){
    		String ss = s.substring(i, i+10);
    		if(tmp.contains(ss))
    			res.add(ss);
    		else
    			tmp.add(ss);
    	}
    	for(String aa:res)
    		rr.add(aa);
    	return rr;
    }
    
    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList<>(repeated);
    }
    public static void main(String[] args) {
    	List<String> res = findRepeatedDnaSequences("AAAAAAAAAAA");
    	System.out.println(res.get(0));
    }
}
