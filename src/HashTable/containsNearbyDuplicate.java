package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class containsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	//�洢ÿ�����ֵ�ֵ�����±�
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
    
    //90%�Ļ�����
    //ʹ�û������ڵķ�����������������������set������K������
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
    	Set<Integer> tmp = new HashSet<>();
    	for(int i=0; i<nums.length; i++){
    		//�Ȱ�numsǰk�����ִ浽tmp�У�Ȼ�󴰿������ƶ���
    		if(i>k) tmp.remove(nums[i-k-1]);
    		
    		if(!tmp.add(nums[i])) return true;   		
    	}
    	return false;
    }    
}
