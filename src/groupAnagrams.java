import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class groupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Set<Integer> used = new HashSet<>();
        for(int i=0; i<strs.length; i++){
        	if(used.contains(i))
        		continue;
        	List<String> ana = new ArrayList<>();
        	used.add(i);
        	ana.add(strs[i]);
        	for(int j=i+1; j<strs.length; j++){
        		if(used.contains(j))
        			continue;
        		if(isAnagram1(strs[i], strs[j])){
        			ana.add(strs[j]);
        			used.add(j);
        		}
        	}
        	res.add(ana);
        }
        return res;
    }
    
    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> used = new HashMap<>();
        for(int i=0; i<strs.length; i++){
        	boolean flag = false;
        	for(String ss : used.keySet()){
        		if(isAnagram1(strs[i], ss)){
        			List<String> aa = used.get(ss);
        			aa.add(strs[i]);
        			used.put(ss, aa);
        			flag = true;
        			break;
        		}
        	}
        	if(flag == false){
			List<String> aa = new ArrayList<>();
			aa.add(strs[i]);
			used.put(strs[i], aa);
        	}
        }
        for(String ss:used.keySet())
        	res.add(used.get(ss));
        return res;
    }
    
    
    public List<List<String>> groupAnagrams3(String[] strs) {
    	if(strs==null || strs.length == 0){
    		return new ArrayList<List<String>>();
    	}
    	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    	//Arrays.sort(strs);
    	for (String s:strs) {
    		char[] ca = s.toCharArray();
    		Arrays.sort(ca);
    		String keyStr = String.valueOf(ca);
    		if(!map.containsKey(keyStr))
    			map.put(keyStr, new ArrayList<String>());
    		map.get(keyStr).add(s);
    	}
    	
    	for(String key: map.keySet()) {
    		Collections.sort(map.get(key));
    	}
    	return new ArrayList<List<String>>(map.values());
    }
    
    //最上面两种方法都是使用了isAnagram这个方法，效率太低。分别使用嵌套遍历两次strs数组和遍历一次数组再嵌套遍历hashMap键值的方法。最后均超时。
    //第三种方法，使用数组中每个字符串进行排序之后的东西作为hashMap的键值，这样省去了嵌套遍历其键值并判断是否为Anagram的步骤，省去了大量时间，但效率依然很低只击败了15%的用户
    //最后这种方法
    public List<List<String>> groupAnagrams4(String[] strs) {
    	int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
    }
    
    public static boolean isAnagram1(String s, String t) {
    	if(s.length() != t.length())
    		return false;
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
		String [] nums = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams2(nums);
		System.out.println(1/10);
	}
}
