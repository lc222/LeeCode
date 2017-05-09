package Array;

/**
 * Created by liuchong on 2017/5/8.
 */
public class canJump {
    public boolean canJump(int[] nums) {
        int max_right=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0 && max_right <= i && i != nums.length-1)
                return false;
            max_right = Math.max(max_right, i+nums[i]);
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        if(nums.length < 2) return true;

        for(int curr = nums.length-2; curr>=0;curr--){
            if(nums[curr] == 0){
                int neededJumps = 1;
                while(neededJumps > nums[curr]){
                    neededJumps++;
                    curr--;
                    if(curr < 0) return false;
                }
            }
        }
        return true;
    }
}
