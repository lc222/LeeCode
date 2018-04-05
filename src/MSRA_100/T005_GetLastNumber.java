package MSRA_100;

import java.util.ArrayList;

public class T005_GetLastNumber {
    public ArrayList<Integer> GetLastNumber(int [] nums, int k){
        ArrayList<Integer> res = new ArrayList<>();
        if(nums == null || nums.length < k)
            return res;
        findKMin(nums, 0, nums.length-1, k);
        for(int i=0; i<k; i++)
            res.add(nums[i]);

        return res;

    }

    public void findKMin(int [] nums, int start, int end, int k){
        int pos = 0;
        if(start < end)
           pos = partition(nums, start, end);
        if(pos == k - 1)
            return;
        else if(pos < k-1)
            findKMin(nums, pos+1, end, k);
        else
            findKMin(nums, start, pos-1, k);
    }

    public int partition(int [] nums, int start, int end){
        int pre = nums[start];
        while(start < end){
            while(start < end && nums[end] >= pre) end--;
            if(start < end) nums[start] = nums[end];
            while(start < end && nums[start] <= pre) start++;
            if(start < end) nums[end] = nums[start];
        }
        nums[start] = pre;
        return start;
    }

    //使用快速排序，分区的思想进行实现，时间复杂度为O(N)
    public int Partition(int[] input, int start, int end){
        int l = start;
        int h = end;
        int pivot = input[start];
        while(l < h){
            while(l < h && input[h] >= pivot)
                h--;
            input[l] = input[h];
            while(l<h && input[l] <= pivot)
                l++;
            input[h] = input[l];
        }
        input[l] = pivot;
        return l;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(input.length <= 0 || input == null || input.length < k || k <= 0)
            return list;
        int start = 0;
        int end = input.length-1;
        int index = Partition(input, start, end);
        while(index != k-1){
            if(index > k-1){
                end = index-1;
                index = Partition(input, start, end);
            }
            else{
                start = index+1;
                index = Partition(input, start, end);
            }
        }
        for(int i = 0; i < k; i++){
            list.add(input[i]);
        }
        return list;
    }

    //使用堆排序进行实现，将前面k各元素保存在堆中，方便查询最小元素
    public ArrayList<Integer> GetLastNumber1(int [] nums, int k){
        ArrayList<Integer> res = new ArrayList<>();
        if(nums == null || nums.length < k)
            return res;
        int [] out = new int[k];
        for(int i=0; i<k; i++)
            out[i] = nums[i];

        //建立大顶堆
        int N = k-1;
        for(int i=k/2; i>=0; i--)
            sink(out, i, N);

        int i=k;
        while(i<nums.length){
            if(nums[i] < out[0]){
                out[0] = nums[i];
                sink(out, 0, N);
            }
            i++;
        }

        for(i=0; i<k; i++)
            res.add(out[i]);
        return res;
    }

    public void sink(int [] out, int k, int N){
        while(2*k < N){
            int j = 2*k + 1;
            if(j < N && out[j] < out[j+1])
                j++;
            if(out[k] > out[j])
                break;
            else{
                int tmp = out[k];
                out[k] = out[j];
                out[j] = tmp;
                k = j;
            }
        }
    }
}
