package Array;

/**
 * Created by liuchong on 2017/4/10.
 */
public class rotate {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        int step = k % nums.length;
        int [] tmp = new int[step];

        for(int i=0; i<step; i++)
            tmp[i] = nums[nums.length-step+i];
        for(int i=nums.length-step-1; i>=0; i--)
            nums[i+step] = nums[i];
        for(int i=0; i<step; i++)
            nums[i] = tmp[i];
    }

    public void rotate1(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,step - 1);
        reverse(nums,step,nums.length - 1);
    }

    //reverse int array from n to m
    public void reverse(int[] nums, int n, int m){
        while(n < m){
            nums[n] ^= nums[m];
            nums[m] ^= nums[n];
            nums[n] ^= nums[m];
            n++;
            m--;
        }
    }
}
