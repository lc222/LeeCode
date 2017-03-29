package HashTable;

import java.util.HashMap;

public class Two_Sum {

	public static int[] twoSum(int[] nums, int target)
	{
		int [] result = new int[2];
		HashMap<Integer, Integer> res = new HashMap<>();
		for(int i=0; i<nums.length; i++)
		{
			int tmp = target - nums[i];
			if(res.containsKey(tmp)){
				result[0] = res.get(tmp);
				result[1] = i+1;
				return result;
			}
			res.put(nums[i], i + 1);
		}
		return result;
	}
	
	public static void main(String[] args){
		int [] nums = {1,2,3,4,5,6,7};
		int target = 7;
		int [] res = twoSum(nums, target);
		System.out.println(res[0] + "  " +res[1]);
		System.out.println(1/10);
	}
}
