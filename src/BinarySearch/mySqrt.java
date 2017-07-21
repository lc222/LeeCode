package BinarySearch;

/**
 * Created by liuchong on 2017/7/19.
 *
 69. Sqrt(x)

 Implement int sqrt(int x).

 Compute and return the square root of x.
 */
public class mySqrt {

    public int sqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    int sqrt1(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int l = 1, r = x, res=1;
        while(l <= r){
            int m = (l + r)/2;
            if(m == x / m){
                return m;
            }else if(m > x / m){
                r = m - 1;
            }else{
                l = m + 1;
                res = m;
            }
        }
        return res;
    }
}
