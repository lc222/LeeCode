package Array;

/**
 * Created by liuchong on 2017/5/4.
 */
public class sortColors {
    public void sortColors(int[] nums) {
        int a=0, b=0;
        for(int num : nums){
            if(num == 0)
                a++;
            else if(num == 1)
                b++;
        }
        for(int i=0; i<nums.length; i++){
            if(i<a)
                nums[i] = 0;
            else if(i < a+b)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }

    public void sortColors1(int[] nums) {
        int n = nums.length, n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0)
            {
                nums[++n2] = 2; nums[++n1] = 1; nums[++n0] = 0;
            }
            else if (nums[i] == 1)
            {
                nums[++n2] = 2; nums[++n1] = 1;
            }
            else if (nums[i] == 2)
            {
                nums[++n2] = 2;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int n=nums.length, j = 0, k = n - 1;
        for (int i = 0; i <= k; ++i){
            if (nums[i] == 0 && i != j)
                swap(nums, i--, j++);
            else if (nums[i] == 2 && i != k)
                swap(nums, i--, k--);
        }
    }

    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
