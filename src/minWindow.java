import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class minWindow {
	//time limit exceeded
    public static String minWindow(String s, String t) {
    	String ss = "";
    	int min = s.length();
    	Map<Character, Integer> map = new HashMap<>();
    	for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        for(int i=0; i<s.length(); i++){
        	Map<Character, Integer> tmp = new HashMap<>();
        	for(int j=i; j<s.length(); j++){
        		char c = s.charAt(j);
        		if(map.containsKey(c)){
        			if(tmp.containsKey(c) && tmp.get(c) < map.get(c))
        				tmp.put(c, tmp.get(c)+1);
        			else if(!tmp.containsKey(c))
        				tmp.put(c, 1);
        			if(tmp.equals(map) && min>j-i){
        				min = j-i;
        				ss = s.substring(i, j+1);
        				break;
        			}
        		}
        	}
        }
        return ss;
    }
    
    public static String minWindow1(String s, String t){
    	char [] tt = new char[256];
    	char [] ss = new char[256];
    	int count = 0;
    	int min = s.length()+1;
    	int begin = 0, end = 0;
    	
    	for(char c : t.toCharArray()) tt[c]++;
    	
    	for(int i=0, left=0; i<s.length(); i++){
    		char c = s.charAt(i);
    		if(tt[c] == 0)
    			continue;
    		ss[c] ++;
    		if(ss[c] <= tt[c])//当s累积的个数没有达到t时，count++。
    			count ++;
    		if(count == t.length()){
    			//如果遍历过的字符已经完全包含了t，则将left游标尽可能向右移动
    			char cc = s.charAt(left);
    			//left移动的规则就是，left索引位置的字符cc不在t中，或者ss中的cc个数>tt中的cc个数
    			while(ss[cc] > tt[cc] || tt[cc] == 0){
    				if(ss[cc] > tt[cc])
    					ss[cc] --;
    				left ++;
    				cc = s.charAt(left);
    			}
    			
    			//如果count==t.length()，则说明已经找到了一个满足条件的子串。如果该子串长度更小，则更新其相应下标信息。
    			if(min > i-left+1){
    				begin = left;
    				end = i;
    				min = i-left+1;
    			}
    		}
    	}
    	if(count != t.length())
    		return "";
    	return s.substring(begin, end+1);
    }
 
    public static void main(String [] args){
    	String s = "aaaaaaaaaaaabbbbbcdd";
    	String t = "abcdd";
    	System.out.println(minWindow(s, t));
    }
}
