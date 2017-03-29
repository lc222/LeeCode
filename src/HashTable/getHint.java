package HashTable;

import java.util.HashMap;

public class getHint {
	//14%
    public static String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        HashMap<Character, Integer> bulls = new HashMap<>();
        HashMap<Character, Integer> cows = new HashMap<>();
        for(int i=0; i<secret.length(); i++){
        	if(secret.charAt(i) == guess.charAt(i))
        		bull += 1;
        	else{
        		if(bulls.containsKey(secret.charAt(i)))
        			bulls.put(secret.charAt(i), bulls.get(secret.charAt(i))+1);
        		else
        			bulls.put(secret.charAt(i), 1);
        		if(cows.containsKey(guess.charAt(i)))
        			cows.put(guess.charAt(i), cows.get(guess.charAt(i))+1);
        		else
        			cows.put(guess.charAt(i), 1);
        	}
        }
        for(Character key : bulls.keySet()){
        	if(cows.containsKey(key)){
	        	if(bulls.get(key) > cows.get(key))
	        		cow += cows.get(key);
	        	else cow += bulls.get(key);
        	}
        }
        return bull + "A" + cow + "B";
    }

    //44%
    public static String getHint1(String secret, String guess) {
        int bull = 0, cow = 0;
        int [] bulls = new int [10];
        int [] cows = new int [10];
        for(int i=0; i<secret.length(); i++){
        	if(secret.charAt(i) == guess.charAt(i))
        		bull += 1;
        	else{
        		bulls[secret.charAt(i) - 48] ++;
        		cows[guess.charAt(i) - 48] ++;
        	}
        }
        for(int i=0; i<10; i++){
        	if(bulls[i]!=0){
        		if(bulls[i] > cows[i])
        			cow += cows[i];
        		else cow += bulls[i];
        	}
        }
        return bull + "A" + cow + "B";
    }

    //54%
    public String getHint2(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bull++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cow++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cow++;
            }
        }
        return bull + "A" + cow + "B";
    }

    //73%
    public String getHint3(String secret, String guess) {
        int s, g, size = secret.length();
        int bulls = 0, cows = 0;
        int [] nums = new int [10];
        for (int i = 0; i < size; i++) {
            s = secret.charAt(i) - '0';
            g = guess.charAt(i) - '0';
            if (s == g)
                bulls ++;
            else{
                if (nums[s] < 0)
                    cows++;
                nums[s]++;
                if (nums[g] > 0)
                    cows++;
                nums[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
    
    public static void main(String[] args){
		int [] nums = {1,2,3,4,5,6,7};
		int target = 7;
		String res = getHint("1", "0");
		System.out.println(res);
		System.out.println(1/10);
	}
}
