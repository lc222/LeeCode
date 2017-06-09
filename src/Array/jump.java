package Array;

/**
 * Created by liuchong on 2017/6/8.
 */
public class jump {
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static int jump1(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        int len = nums.length, step = 0;
        for (int i = 0; i < len; i++) {
            if (i + nums[i] >= nums.length - 1) {
                step++;
                return step;
            }

            int max = -1, position = i + 1;
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j - i + nums[j] > max) {
                    max = j - i + nums[j];
                    position = j;
                }
            }
            i = position - 1;
            step++;
        }
        return 0;
    }

    int jump2(int A[]) {
        if(A.length<2)return 0;
        int level=0,currentMax=0,i=0,nextMax=0;

        while(currentMax-i+1>0){		//nodes count of current level>0
            level++;
            for(;i<=currentMax;i++){	//traverse current level , and update the max reach of next level
                nextMax=Math.max(nextMax,A[i]+i);
                if(nextMax>=A.length-1)return level;   // if last element is in level+1,  then the min jump=level
            }
            currentMax=nextMax;
        }
        return 0;
    }
}
