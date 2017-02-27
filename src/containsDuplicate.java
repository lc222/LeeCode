import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        for(int num : nums)
        {
        	if(!tmp.add(num))
        		return true;
        }
        return false;
    }
    
    //加了排序之后时间增加，说明这里排序相对而言是一个不明智的选择。
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        Arrays.sort(nums);
        for(int num : nums)
        {
        	if(!tmp.add(num))
        		return true;
        }
        return false;
    }    
  //这是效率最高的实现方法。相比set这里仅仅是一个循环
    public boolean containsDuplicate2(int[] nums) {
    	Arrays.sort(nums);
    	for(int i=0; i<nums.length; i++)
    		if(nums[i] == nums[i+1])
    			return true;
    	return false;
    }
    
    //这个算法打败了98%的选手！！！！！！！！！！！！！！！！！！！！！！！！！！！
    //这种byte的位运算很是奇妙，我一定要明白！！！！！！！！！！！！！！！！！！！
    public boolean containsDuplicate3(int[] nums) {
        byte[] mark = new byte[150000];
        for (int i : nums) {
            int j = i/8;
            int k = i%8;
            int check = 1<<k;
            if ((mark[j] & check) != 0) {
                return true;
            }
            mark[j]|=check;
        }
        return false;
    }
}
