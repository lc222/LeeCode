package HashTable;

import java.util.HashSet;
import java.util.Set;

public class isHappy {
    public static boolean isHappy(int n) {
    	Set<Integer> tmp = new HashSet<>();
        while(true){
        	int sum = 0;
        	while(n!=0){
        		sum += (n%10)*(n%10);
        		n /= 10;
        	}
        	if(sum == 1)
        		return true;
        	else if(tmp.add(sum))
        		n = sum;
        	else
        		return false;
        }
    }
    
    public boolean isHappy1(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
    
	public static void main(String[] args){
		boolean aa = isHappy(18);
		System.out.println(aa);
		System.out.println((3%10)^2);
	}
}
