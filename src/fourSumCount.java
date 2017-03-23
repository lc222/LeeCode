import java.util.HashMap;
import java.util.Map;

public class fourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++)
        	for(int j=0; j<A.length; j++)
        		map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0)+1);
        int res = 0;
        for(int i=0; i<A.length; i++)
        	for(int j=0; j<A.length; j++){
        		if(map.containsKey(-C[i]-D[j]))
        			res += map.get(-C[i]-D[j]);
        	}
        return res;
    }
    
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A )
        	for(int b : B)
        		map.put(a+b, map.getOrDefault(a+b, 0)+1);
        int res = 0;
        for(int c : C)
        	for(int d : D){
        		if(map.containsKey(-c-d))
        			res += map.get(-c-d);
        	}
        return res;
    }
}
