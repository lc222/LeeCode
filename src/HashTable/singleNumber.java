package HashTable;

import java.util.Arrays;

public class singleNumber {
    public int singleNumber(int[] nums) {
    	if (nums.length == 1)
    		return nums[0];
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i+=2){
        	if(nums[i] != nums[i+1])
        		return nums[i];
        }
        return nums[nums.length-1];
    }
    
    public static int singleNumber1(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 1;
    	if (high == 0)
    		return nums[0];
        Arrays.sort(nums);
        while(low <= high && mid < nums.length-1 && mid > 0)
        {        	
        	if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
        		return nums[mid];
        	else if(nums[mid] == nums[mid+1] && mid%2 == 0)
        		low = mid+2;
        	else if(nums[mid] == nums[mid-1] && mid%2 == 1)
        		low = mid+1;
        	else if(nums[mid] == nums[mid-1] && mid%2 == 0)
        		high = mid-2;
        	else if(nums[mid] == nums[mid+1] && mid%2 == 1)
        		high = mid-1;
        	mid = (high+low)/2;
        }
        return nums[mid];
    }
    
    public int singleNumber2(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }
    
	public static void main(String[] args){
		int [] nums = {17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6};
		int res = singleNumber1(nums);
		System.out.println(res);
	}
}
