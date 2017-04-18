package Array;

import sun.java2d.pipe.AAShapePipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuchong on 2017/4/18.
 */
public class subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        for(int num : nums){
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> list : res){
                List<Integer> aa = new ArrayList<>(list);
                aa.add(num);
                if(!res.contains(aa))
                    tmp.add(aa);
            }
            res.addAll(tmp);
        }
        return res;
    }

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int begin = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]) begin = 0;
            int size = result.size();
            for(int j = begin; j < size; j++){
                List<Integer> cur = new ArrayList<>(result.get(j));
                cur.add(nums[i]);
                result.add(cur);
            }
            begin = size;
        }
        return result;
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        dfs(nums,0,new ArrayList<Integer>(),result);
        return result;
    }

    public void dfs(int[] nums,int index,List<Integer> path,List<List<Integer>> result){
        result.add(path);
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]) continue;
            List<Integer> nPath= new ArrayList<>(path);
            nPath.add(nums[i]);
            dfs(nums,i+1,nPath,result);
        }
    }
}
