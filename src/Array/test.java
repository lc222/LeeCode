package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by liuchong on 2017/4/19.
 */
public class test {
    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return 0;
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        for(int i=0; i<nums.length-2; i++){
            if(i == 0 || (i>0 && nums[i] != nums[i+1])){
                int j=i+1, n=nums.length-1, tmp = target-nums[i];
                while(j < n){
                    if(nums[j] + nums[n] == tmp)
                        return 0;
                    else if(nums[n] + nums[j] > tmp){
                        if(nums[j] + nums[n] - tmp < min){
                            min = nums[j] + nums[n] - tmp;
                            flag = true;
                        }
                        n--;
                    }else{
                        if(tmp - nums[j] - nums[n] <min){
                            min = tmp - nums[j] - nums[n];
                            flag = false;
                        }
                        j++;
                    }
                }
            }
        }
        return flag?target+min:target-min;
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.equals(""))
            return 0;
        char [] ch = s.toCharArray();
        int [] count = new int[256];
        int left = 0, max = 1;
        for(int i=0; i<ch.length; i++){
            if(count[ch[i]] == 0){
                count[ch[i]] = 1;
            }else{
                max = Math.max(max, i-left);
                left += 1;
            }
        }

        return Math.max(max, ch.length-left);
    }
    public static  void main(String[] args){
        int [] a = {1,1,1, 0};
        lengthOfLongestSubstring("pwwkew");
//        System.out.println("请输入N，M");
//        Scanner scan = new  Scanner(System.in);
//        int  N = scan.nextInt();
//        int  M = scan.nextInt();
//
//        if(N >= 1 && M>=1){
//            int kind = color(N,M);
//            System.out.println ("涂颜色种类为"+kind);
//        }
//        ArrayList<Integer> a= new ArrayList<>();
//        plus(a);
//        System.out.println(a);
    }

    public static void plus(ArrayList<Integer> a){
         a.add(100);
    }
    public static int color (int N,int M){
        int kind_new = 0;
        if(N == 1 && M >=1)
            return M;
        if(N == 2 && M >=2)
            return M*(M-1);
        if(N == 3 && M>=3)
            return M*(M-1)*(M-2);
        if(N >3 && M >=2){
            kind_new=color(N-1,M)*(M-2) + color(N-2,M)*(M-1);//迭代 分两种情况 求和
        }
        return kind_new;
    }
}
