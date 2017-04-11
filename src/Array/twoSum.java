package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuchong on 2017/4/11.
 */
public class twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int [2];
        int left = 0, right = numbers.length-1;
        while(left < right){
            int tmp = numbers[left] + numbers[right];
            if(tmp == target){
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }else if(tmp < target)
                left ++;
            else
                right --;
        }
        return res;
    }

    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int [] res = new int[2];
        for(int i=0; i<numbers.length; i++){
            if(map.containsKey(numbers[i])){
                res[0] = map.get(numbers[i]);
                res[1] = i+1;
                break;
            }else
                map.put(target-numbers[i], i+1);
        }
        return res;
    }

}
