package Sort_func.arraySort.arraySort;

/**
 * 冒泡排序
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * Created by liuchong on 2017/6/27.
 */
public class BubbleSort {

    public void BubbleSort(int[] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=1; j<nums.length-i; j++){
                if(nums[j-1] > nums[j])
                    swap(nums, j);
            }
        }
    }

    public void swap(int[] nums, int i){
        int tmp = nums[i];
        nums[i] = nums[i+1];
        nums[i+1] = tmp;
    }


    //冒泡排序算法有两种改进方式：
    //1，如果又一次循环，并未发生任何交换，则说明数组已经排序完成。可以设置一个标志来表示
    //2，记录某次遍历时最后发生数据交换的位置，这个位置之后的数据显然已经有序，不用再排序了。因此通过记录最后发生数据交换的位置就可以确定下次循环的范围了。
    public void BubbleSort1(int[] nums){
        //最后发生交换的标志位
        int last = nums.length;
        for(int i=0; i<nums.length; i++){
            boolean flag = true;
            for(int j=1; j<last; j++){
                if(nums[j-1] > nums[j]) {
                    swap(nums, j);
                    last = j;
                    flag = false;
                }
            }
            if(flag)
                break;
        }
    }

}
