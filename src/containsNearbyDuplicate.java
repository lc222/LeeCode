import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class containsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	//存储每个数字的值和其下标
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    
    //90%的击败绿
    //使用滑动窗口的方法！！！！！！！！集合set仅保存K个数字
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
    	Set<Integer> tmp = new HashSet<>();
    	for(int i=0; i<nums.length; i++){
    		//先把nums前k个数字存到tmp中，然后窗口向右移动。
    		if(i>k) tmp.remove(nums[i-k-1]);
    		
    		if(!tmp.add(nums[i])) return true;   		
    	}
    	return false;
    }    
}
