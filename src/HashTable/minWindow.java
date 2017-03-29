package HashTable;

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
    		if(ss[c] <= tt[c])//��s�ۻ��ĸ���û�дﵽtʱ��count++��
    			count ++;
    		if(count == t.length()){
    			//������������ַ��Ѿ���ȫ������t����left�α꾡���������ƶ�
    			char cc = s.charAt(left);
    			//left�ƶ��Ĺ�����ǣ�left����λ�õ��ַ�cc����t�У�����ss�е�cc����>tt�е�cc����
    			while(ss[cc] > tt[cc] || tt[cc] == 0){
    				if(ss[cc] > tt[cc])
    					ss[cc] --;
    				left ++;
    				cc = s.charAt(left);
    			}
    			
    			//���count==t.length()����˵���Ѿ��ҵ���һ�������������Ӵ���������Ӵ����ȸ�С�����������Ӧ�±���Ϣ��
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
