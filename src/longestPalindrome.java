
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
    
    //上面两种方法都是采用int型数组来保存字符串s的信息，然后进行遍历。虽然第二种使用两个长度为26的数组来减少数组长度，但带来的改进效果甚少。效果相同都是几百60%的用户
    
    //下面这种方法仅对s进行遍历，而不需要在对数组map遍历求和。所以效率更高。击败了93%的用户。其思路是使用布尔数组每出现两次则抵消并给结果+2.
    //最终如果len小于s，则说明s中的字符并不是全部出现偶数次，仅需对len加一即可。
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
