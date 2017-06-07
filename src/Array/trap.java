package Array;

/**
 * Created by liuchong on 2017/6/2.
 */
public class trap {
    //超时
    public int trap(int[] height) {
        int res = 0;
        for(int i=1; i<height.length-1; i++){
            res += find(height, i);
        }
        return res;
    }

    public int find(int[] height, int i){
        int left=0, right=0;
        for(int j=0; j<i; j++)
            left = Math.max(left, height[j]);
        for(int j=i+1; j<height.length; j++)
            right = Math.max(right, height[j]);
        if(height[i] < left && height[i] < right)
            return Math.min(left, right) - height[i];
        else
            return 0;
    }

    public int trap1(int[] height) {
        int res = 0, left=0;
        for(int i=1; i<height.length; i++) {
            if (height[i] >= height[left]) {
                int tmp = height[left];
                while (++left < i) {
                    res += tmp - height[left];
                }
            }
        }
        while(++left<height.length-1)
            res += Math.max(0, height[height.length-1] - height[left]);
        return res;
    }
    //60%
    public int trap2(int[] height){
        int res=0, max=0, left=0, right=height.length-1;
        for(int i=1; i<height.length; i++)
            if(height[i] > height[max])
                max = i;
        for(int i=1; i<max; i++){
            if(height[i] < height[left])
                res += height[left] - height[i];
            else
                left = i;
        }
        for(int i=height.length-2; i>max; i--){
            if(height[i] < height[right])
                res += height[right]-height[i];
            else
                right = i;
        }
        return res;
    }
    //88%
    public int trap3(int[] A) {
        int i = 0, j = A.length - 1, result = 0, plank = 0;
        while(i <= j){
            plank = plank < Math.min(A[i], A[j]) ? Math.min(A[i], A[j]) : plank;
            result = A[i] >= A[j] ? result + (plank - A[j--]) : result + (plank - A[i++]);
        }
        return result;
    }
}
