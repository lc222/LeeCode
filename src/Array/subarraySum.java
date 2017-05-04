package Array;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by liuchong on 2017/5/3.
 */
public class subarraySum {
    public int subarraySum(int[] nums, int k) {
        int sum=0, count=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k))
                count += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            if(sum==k){
                count++;
            }
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k) count++;
            }
        }
        return count;
    }
}
