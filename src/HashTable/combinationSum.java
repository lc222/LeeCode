package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int j=0;
        for(int i=0; i<candidates.length; i++){
        	if(candidates[i]<target)
        		tmp.add(candidates[i]);
        	else return res;
        	while(j<candidates.length){
        		
        	}
        }
        return res;
    }
    
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
    	Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        getResult(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    private static void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
    	if(target>0)
    		for(int i=start; i<candidates.length && candidates[i]<=target; i++){
    			cur.add(candidates[i]);
    			getResult(result, cur, candidates, target - candidates[i], i);
    			cur.remove(cur.size() - 1);
    		}
    	else if(target == 0)
    		result.add(new ArrayList<Integer>(cur));
    }
    
	public static void main(String[] args){
		int [] nums = {1,2,3,4,5,6,7};
		int target = 7;
		List<List<Integer>> res = combinationSum1(nums, target);
		System.out.println();
		
	}
}
