package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by liuchong on 2017/5/23.
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum1(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i=0;i<num.length;i++)
        {
            for(int j=i+1,k=num.length-1;j<k;)
            {
                if(num[i]+num[j]+num[k]==0)
                {
                    List<Integer> l= new ArrayList<Integer>();
                    l.add(num[i]);
                    l.add(num[j]);
                    l.add(num[k]);
                    if(set.add(l))
                        list.add(l);
                    j++;
                    k--;
                }
                else if(num[i]+num[j]+num[k]<0)
                    j++;
                else
                    k--;
            }
        }
        return list;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            // **if nums[i]>0 there is no chance to find three element giving the  sum of 0**
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int low=i+1;
            int high=nums.length-1;
            int sum = -nums[i];
            while(low<high){
                if(nums[low]+nums[high]==sum){
                    res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while(low<high && nums[low]==nums[low+1]) low++;
                    low++;
                    while(low<high && nums[high]==nums[high-1]) high--;
                    high--;
                }else if(nums[low]+nums[high]>sum){
                    while(low<high && nums[high]==nums[high-1]) high--;
                    high--;
                }
                else{
                    while(low<high && nums[low]==nums[low+1]) low++;
                    low++;
                }

            }
        }
        return res;
    }
}
