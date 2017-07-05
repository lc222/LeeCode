package Sort_func.arraySort.arraySort;

/**
 * 对于一个数组，我们选定一个基准数据（例如：数组中的最后一个或者第一个元素），
 * 剩下的数据组成一个新的数组，然后遍历这个新数组中的每一个元素，
 * 分别与基准元素进行对比，分别将小于基准元素和不小于基准元素的数据区分开来，
 * 这个时候基准元素在总的数组中的位置就确定了。然后，
 * 在分别对这个两个数组进行相同的操作，直到每一个元素的位置都唯一确定下来。
 * Created by liuchong on 2017/6/28.
 */
public class QuickSort {

    public void QuickSort(int[] nums){
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] a,int low,int high){
        //左
        int l =low;
        //右
        int h = high;
        //基准值
        int k = a[low];
        //判断一趟是否完成
        while(l<h){
            //若顺序正确就比较下一个
            while(l<h&&a[h]>=k)
                h--;
            if(l<h){
                int temp = a[h];
                a[h] = a[l];
                a[l] = temp;
                l++;
            }
            while(l<h&&a[l]<=k)
                l++;
            if(l<h){
                int temp = a[h];
                a[h] = a[l];
                a[l] = temp;
                h--;
            }
        }
        if(l>low) sort(a,low,l-1);
        if(h<high) sort(a,l+1,high);
    }
}
