package Array;

/**
 * Created by liuchong on 2017/5/15.
 */
public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int mul = 1;
        for(int num : nums)
            mul *= num;
        for(int i=0; i<nums.length; i++){
            res[i] = mul / nums[i];
        }
        return res;
    }

    public  int[] productExpectSelf1(int[] nums){
        int[] res = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int tmp = 1;
            for(int j=0; j<nums.length; j++)
                if(j != i)
                    tmp *= nums[j];
            res[i] = tmp;
        }

        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }


}
