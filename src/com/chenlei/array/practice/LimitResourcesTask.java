package com.chenlei.array.practice;

/**
 *  36. 有限资源下的任务调度
 * @author chenlei
 * @since 2017 - 05 - 21 13:33
 */
public class LimitResourcesTask {

    private static void specialSort(Task a[]) {
        for(int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < a.length; j++) {
                if(specialMin(a, j, minIndex) == j) {
                    minIndex = j;
                }
            }
            Task temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    //贪心算法，r-o越大，优先级越高
    private static int specialMin(Task a[], int i, int j) {
        int reduceI = a[i].r - a[i].o;
        int reduceJ = a[j].r - a[j].o;
        return reduceI < reduceJ ? i : j;
    }

    public static void main(String[] args) {
        Task a = new Task();
        a.r = 10;
        a.o = 5;
        Task b = new Task();
        b.r = 8;
        b.o = 6;
        Task array[] = {a, b};
        specialSort(array);
        int m = 14;
        for(int i = array.length - 1; i >= 0; i--) {
            Task task = array[i];
            if(m >= task.r) {
                m -= task.o;
            } else {
                System.out.println("找不到满足条件的顺序");
                return;
            }
        }
        System.out.println("找到了满足要求的执行顺序");
    }

    private static class Task{
        int r; //运行任务的空间前置
        int o; //运行任务后的所需储存空间
    }
}
