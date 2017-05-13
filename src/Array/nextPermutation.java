package Array;

/**
 * Created by liuchong on 2017/5/9.
 */
public class nextPermutation {
    public void nextPermutation(int[] nums) {
        /* 1. Reverse find first number which breaks descending order. */
        int i=nums.length-1;
        for(; i>=1; i--)
            if(nums[i-1]<nums[i]) break;

        /* if no break found in step 1 */
        if(i==0){
            /* for case "1" and "1111" */
            if(nums.length==1 || nums[0]==nums[1]) return;
            /* for case "54321" */
            int lo=i, hi=nums.length-1;
            while(lo<hi) swap(nums, lo++, hi--);
            return;
        }

        /* 2. Exchange this number with the least number that's greater than this number. */
        /* 2.1 Find the least number that's greater using binary search, O(log(nums.length-i)) */
        int j = binarySearchLeastGreater(nums, i, nums.length-1, nums[i-1]);

        /* 2.2 Exchange the numbers */
        if(j!=-1) swap(nums, i-1, j);

        /* 3. Reverse sort the numbers after the exchanged number. */
        int lo=i, hi=nums.length-1;
        while(lo<hi) swap(nums, lo++, hi--);
    }

    public int binarySearchLeastGreater(int[] nums, int lo, int hi, int key){
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]>key){
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return hi;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
