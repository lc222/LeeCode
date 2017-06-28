package Sort_func;

/**
 * 从第一个元素开始，该元素可以认为已经被排序
 取出下一个元素，在已经排序的元素序列中从后向前扫描
 如果被扫描的元素（已排序）大于新元素，将该元素后移一位
 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 将新元素插入到该位置后
 重复步骤2~5
 * Created by liuchong on 2017/6/27.
 */
public class InsertionSort {

    public void InsertionSort(int[] nums){
        for(int i=1; i<nums.length; i++){
            if(nums[i] < nums[i-1]){
                int tmp = nums[i];
                int index = i;
                for(int j=i-1; j>=0; j--){
                    if(nums[j] > nums[i]) {
                        nums[index] = nums[j];
                        index = j;
                    }else
                        break;
                }
                nums[index] = tmp;
            }
        }
    }
}
