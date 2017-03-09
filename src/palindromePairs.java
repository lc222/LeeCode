import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class palindromePairs {
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<words.length-1; i++)
        	for(int j=i+1; j<words.length; j++){
        		String word = words[i] + words[j];
        		if(isPalindrome(word)){
        			List<Integer> tmp = new ArrayList<>();
        			tmp.add(i);
        			tmp.add(j);
        			res.add(tmp);
        		}
        		String word1 = words[j] + words[i];
        		if(isPalindrome(word1)){
        			List<Integer> tmp = new ArrayList<>();
        			tmp.add(j);
        			tmp.add(i);
        			res.add(tmp);
        		}
        	}
        return res;
    }
    
    public static List<List<Integer>> palindromePairs1(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++) map.put(words[i], i);
        for(int i=0; i<words.length; i++){
        	int l=0, r=0;
        	while(l<=r){
        		String s = words[i].substring(l, r);
        		Integer j = map.get(new StringBuilder(s).reverse().toString());
        		if(j != null && i != j && isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() :l)))
        			res.add(Arrays.asList(l == 0 ? new Integer []{i, j} : new Integer[]{j, i}));
        		if(r < words[i].length()) ++r;
        		else ++l;
        	}
        }
        return res;
    }
    
    public List<List<Integer>> palindromePairs2(String[] words) {
        List<List<Integer>> ret = new ArrayList<>(); 
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);
        for (int i=0; i<words.length; i++) {
            // System.out.println(words[i]);
            for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        ret.add(list);
                        // System.out.printf("isPal(str1): %s\n", list.toString());
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        ret.add(list);
                        // System.out.printf("isPal(str2): %s\n", list.toString());
                    }
                }
            }
        }
        return ret;
    }
    
    public static boolean isPalindrome (String word){
    	for(int i=0, j=word.length()-1; i<j; i++, j--){
    		if(word.charAt(i) == word.charAt(j))
    			continue;
    		else
    			return false;
    	}
    	return true;
    }
    public static void main(String [] args){
    	boolean aa = isPalindrome("aabbaa");
    	System.out.println(aa);
    	boolean bb = isPalindrome("aababaa");
    	System.out.println(bb);
    	String [] words = {"abcd","dcba","lls","s","sssll"};
    	palindromePairs(words);
    }
}
