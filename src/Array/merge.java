package Array;

import java.util.Arrays;

/**
 * Created by liuchong on 2017/4/12.
 */
public class merge {
    //效率很低
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<n; i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);

    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n){
        int num1=0, num2=0;
        while(num1<m && num2<n){
            if(nums1[num1] < nums2[num2])
                num1++;
            else if(nums1[num1] >= nums2[num2]){
                insert(nums1, m, num1, nums2[num2]);
                num1++;
                num2++;
                m++;
            }
        }
        while(num2 < n){
            nums1[m++] = nums2[num2++];
        }
    }
    public static void insert(int [] nums, int len, int idx, int num){
        for(int i=len; i>idx; i--)
            nums[i] = nums[i-1];
        nums[idx] = num;
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n){
        int num1=m-1, num2=n-1, num=m+n-1;
        while(num1>=0 && num2>=0){
            if(nums1[num1] > nums2[num2]) {
                nums1[num--] = nums1[num1--];
            }else {
                nums1[num--] = nums2[num2--];
            }
        }
        while (num2>=0)
            nums1[num--] = nums2[num2--];
    }

    public static void main(String [] args){
        int[] nums1 = new int[15];
        for(int i=0; i<5; i++)
            nums1[i] = 2*i+1;
        int[] nums2 = {2,4,6,8,10,12,14};
        merge1(nums1, 5, nums2, 7);
        System.out.println(nums1.toString());
    }
}
