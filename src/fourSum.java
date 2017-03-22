import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class fourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0, L=nums.length; i<L-3; i++) {
            if(nums[i]<<2 > target) return list; // return immediately
            for(int j=L-1; j>i+2; j--) {
                if(nums[j]<<2 < target) break; // break immediately
                int rem = target-nums[i]-nums[j];
                int lo = i+1, hi=j-1;
                while(lo<hi) {
                    int sum = nums[lo] + nums[hi];
                    if(sum>rem) --hi;
                    else if(sum<rem) ++lo;
                    else {
                        list.add(Arrays.asList(nums[i],nums[lo],nums[hi],nums[j]));
                        while(++lo<=hi && nums[lo-1]==nums[lo]) continue; // avoid duplicate results
                        while(--hi>=lo && nums[hi]==nums[hi+1]) continue; // avoid duplicate results
                    }
                }
                while(j>=1 && nums[j]==nums[j-1]) --j; // skip inner loop
            }
            while(i<L-1 && nums[i]==nums[i+1]) ++i; // skip outer loop
        }
        return list;
    }
	
	public List<List<Integer>> fourSum1(int[] nums, int target) {
		Arrays.sort(nums);
		Map<Integer, List<int[]>> map = new HashMap<>();
		Set<List<Integer>> set = new HashSet<>();
		
		for(int i=0; i<nums.length; i++){
			if(i>1 && nums[i]==nums[i-2]) continue;
			for(int j=i+1; j<nums.length; j++){
				if(j>i+2 && nums[j]==nums[j-2]) continue;
				if(map.containsKey(target - (nums[i]+nums[j]))){
					List<int[]> tmp = map.get(target-(nums[i]+nums[j]));
					for(int[] aa : tmp){
						int m1 = Math.min(i, aa[0]);
						int m2 = Math.min(aa[1], j);
						int m3 = Math.max(aa[0], i);
						int m4 = Math.max(j, aa[1]);
						if(m1 == m3 || m1 == m4 || m2==m3 || m2==m4) continue;
						set.add(Arrays.asList(nums[m1], nums[Math.min(m2, m3)], nums[Math.max(m2, m3)], nums[m4]));
					}
				}
				map.computeIfAbsent(nums[i]+nums[j], key->new ArrayList<>()).add(new int[]{i, j});
			}
		}
		return new ArrayList<List<Integer>>(set);
	}
}
