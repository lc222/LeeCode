package HashTable;

public class longestPalindrome {
    public int longestPalindrome(String s) {
        int[] tmp = new int[128];
        int res = 0;
        boolean symbol = false;
        for(char c : s.toCharArray())
        	tmp[(int)c] += 1;
        for(int a : tmp){
        	if(a%2 == 0)
        		res += a;
        	else if(a>0){
        		symbol = true;
        		res += a-1;
        	}
        }
        if(symbol == true)
        	res += 1;
        return res;
    }
    
    public int longestPalindrome2(String s) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (temp >= 97) lowercase[temp-'a']++;
            else uppercase[temp-'A']++;
        }
        for (int i = 0; i < 26; i++){
            res+=(lowercase[i]/2)*2;
            res+=(uppercase[i]/2)*2;
        }
        return res == s.length() ? res : res+1;
    }
    
    //�������ַ������ǲ���int�������������ַ���s����Ϣ��Ȼ����б�������Ȼ�ڶ���ʹ����������Ϊ26���������������鳤�ȣ��������ĸĽ�Ч�����١�Ч����ͬ���Ǽ���60%���û�
    
    //�������ַ�������s���б�����������Ҫ�ڶ�����map������͡�����Ч�ʸ��ߡ�������93%���û�����˼·��ʹ�ò�������ÿ��������������������+2.
    //�������lenС��s����˵��s�е��ַ�������ȫ������ż���Σ������len��һ���ɡ�
    public int longestPalindrome3(String s) {
        boolean[] map = new boolean[128];
        int len = 0;
        for (char c : s.toCharArray()) {
            map[c] = !map[c];         // flip on each occurrence, false when seen n*2 times
            if (!map[c]) len+=2;
        }
        if (len < s.length()) len++; // if more than len, atleast one single is present
        return len;
    }
}
