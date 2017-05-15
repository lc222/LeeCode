package Array;

/**
 * Created by liuchong on 2017/5/13.
 */
public class maxArea {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i=0; i<height.length-1; i++){
            int tmp = height[i];
            for(int j=i+1; j<height.length; j++){
                max = Math.max(max, (j-i)*Math.min(tmp, height[j]));
            }
        }
        return max;
    }

    public int maxArea1(int[] height){
        int max = 0, left=0, right=height.length-1;
        while(left < right){
            if(height[left] < height[right]){
                max = Math.max(max, (right-left)*height[left]);
                left ++;
            }else{
                max = Math.max(max, (right-left)*height[right]);
                right --;
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max = 0;
        while(lo < hi) {
            int min = Math.min(height[lo], height[hi]);
            max = Math.max(max, min * (hi - lo));
            while(lo <= hi && height[lo] <= min) lo++;
            while(lo <= hi && height[hi] <= min) hi--;
        }
        return max;
    }
}
