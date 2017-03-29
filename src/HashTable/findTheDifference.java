package HashTable;

public class findTheDifference {
	//8ms
    public char findTheDifference(String s, String t) {
        // Initialize variables to store sum of ASCII codes for 
        // each string
        int charCodeS = 0, charCodeT = 0;
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i) charCodeS += (int)s.charAt(i);
        for (int i = 0; i < t.length(); ++i) charCodeT += (int)t.charAt(i);
        // Return the difference between 2 strings as char
        return (char)(charCodeT - charCodeS);
    }
    //6ms,��֪��Ϊʲô�������ֲ��
    public char findTheDifference3(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        
        int asciis = 0;
        int asciit = 0;
        
        for(int i = 0; i < array1.length; i++){
            asciis += (int)array1[i];
        }
        
        for(int i = 0; i < array2.length; i++){
            asciit += (int)array2[i];
        }
        
        return (char)(asciit-asciis);
    }
    
    public char findTheDifference1(String s, String t) {
    	int n = t.length();
    	char c = t.charAt(n-1);
    	for(int i=0; i<n-1; ++i){
    		c ^= s.charAt(i);
    		c ^= t.charAt(i);
    	}
    	return c;
    }
    
    public char findTheDifference2(String s, String t) {
		 int alpha[] = new int[26];
		 for (int i = 0; i < 26; i++) alpha[i] = 0;
		    for (char c : s.toCharArray())
		        alpha[ c - 'a' ]++;

		for (char c : t.toCharArray()) {
		   //could do decrement first, then check but yeah
		if (--alpha[c - 'a'] < 0)
		        return c;
		}
		
		return 0;
    }
}
