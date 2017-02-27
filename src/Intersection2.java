import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i=0, j=0;
        while(i<nums1.length && j < nums2.length)
        {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        int [] result = new int[res.size()];
        int k = 0;
        for(Integer num : res){
        	result[k++] = num;
        }
        return result;
    }
    
    public int[] intersect1(int[] nums1, int[] nums2){
    	Map<Integer, Integer> tmp = new HashMap<>();
    	for(int i=0; i<nums1.length; i++){
    		if(!tmp.containsKey(nums1[i]))
    			tmp.put(nums1[i], 1);
    		else
    			tmp.put(nums1[i], tmp.get(nums1[i])+1);
    	}
    	List<Integer> res = new ArrayList<>();
    	for(int i=0; i<nums2.length; i++){
    		if(tmp.containsKey(nums2[i]) && tmp.get(nums2[i]) > 0)
    		{
    			res.add(nums2[i]);
    			tmp.put(nums2[i], tmp.get(nums2[i])-1);
    		}
    	}
        int [] result = new int[res.size()];
        int k = 0;
        for(Integer num : res){
        	result[k++] = num;
        }
        return result;
    }
    public int[] intersect2(int[] nums1, int[] nums2){
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    
    int i = 0;
    int iL = nums1.length;
    
    int j = 0;
    int jL = nums2.length;
    
    int counter = 0;
    int[] results = new int [iL < jL ? iL : jL];
    
    while (i < iL && j < jL) {
        if (nums1[i] == nums2[j]) {
            results[counter++] = nums1[i];
            i++;
            j++;
        } else if (nums1[i] > nums2[j]) {
            j++;
        } else {
            i++;
        }
    }
    return Arrays.copyOf(results, counter);
    }
}
