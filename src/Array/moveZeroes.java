package Array;

/**
 * Created by liuchong on 2017/4/14.
 */
public class moveZeroes {
    public static void moveZeroes(int[] nums) {
        int count=0, left=0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == 0)
                count++;
            else
                nums[i - count] = nums[i];
        }
        for(int i=0; i<count; i++)
            nums[nums.length-i-1] = 0;
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void main(String [] args){
        int [] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
