package Array;

import java.util.Arrays;

/**
 * Created by liuchong on 2017/6/12.
 */
public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 1;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0)
                if(nums[i] != 1)
                    return 1;
                else{
                    while(i < nums.length-1 && (nums[i+1] == nums[i]+1 || nums[i+1] == nums[i]))
                        i++;
                    return nums[i]+1;
                }
        }
        return nums[nums.length-1]+1;
    }

    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n+2];

        for(int i=0; i<n; i++){
            if(nums[i] > 0 && nums[i] < n+2){
                tmp[nums[i]] = 1;
            }
        }
        for(int i=1; i<n+2; i++)
            if(tmp[i] != 1)
                return i;

        return 1;
    }

    public int firstMissingPositive2(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
