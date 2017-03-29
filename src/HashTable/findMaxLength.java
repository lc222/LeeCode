package HashTable;

import java.util.HashMap;
import java.util.Map;

public class findMaxLength {
    public static int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            }
            else {
                sumToIndex.put(sum, i);
            }
        }
        
        return max;
    }
    
    public static int findMaxLength1(int[] nums) {
    	int res = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	int n = nums.length;
    	int [] diff = new int[n+1];
    	map.put(0, 0);
    	
    	for(int i=1; i<=n; i++){
    		diff[i] = diff[i-1] + (nums[i-1] == 0 ? -1 : 1);
    		if(!map.containsKey(diff[i]))
    			map.put(diff[i], i);
    		else
    			res = Math.max(res, i-map.get(diff[i]));
    	}
    	return res;
    }
    
    public int findMaxLength2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{put(0,0);}};
        int maxLength = 0, runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            Integer prev = map.get(2*runningSum-i-1);
            if (prev != null) maxLength = Math.max(maxLength, i+1-prev);
            else map.put(2*runningSum-i-1, i+1);
        }
        return maxLength;
    }
    
    
    public static void main(String[] args) {
    	int[] nums = {1,0,1,1,0,1,1,1,0,0,0,1,1,0,0,0};
    	int max =findMaxLength(nums);
    }
}
