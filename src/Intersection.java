import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> set = new HashSet<>();
    	Set<Integer> intersect = new HashSet<>();
    	for(int i=0; i<nums1.length; i++)
    	{
    		set.add(nums1[i]);
    	}
    	for(int i=0; i<nums2.length; i++)
    	{
    		if(set.contains(nums2[i]))
    		{
    			intersect.add(nums2[i]);
    		}
    	}
    	int [] result = new int[intersect.size()];
    	int i=0;
    	for(Integer num : intersect)
    	{
    		result[i] = num;
    		i++;
    	}
    		
    	return result;
    }
    
    public static int[] intersection1(int[] nums1, int[] nums2)
    {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
    
	public static void main(String[] args){
		int [] nums1 = {1,2};
		int [] nums2 = {2,1};
		int target = 7;
		int [] res = intersection(nums1, nums2);
		System.out.println(res[0] + "  " +res[1]);
		
	}
}
