package Sort_func.arraySort.arraySort;

/**
 * 在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 *再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *以此类推，直到所有元素均排序完毕。
 * Created by liuchong on 2017/6/27.
 */
public class SelectionSort {
    public void SelectionSort(int[] nums){
        for(int i=0; i<nums.length; i++){
            int min = i;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] < nums[min])
                    min = j;
            }
            swap(nums, i, min);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
