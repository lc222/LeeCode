package BinarySearch;

/**
 * Created by liuchong on 2017/7/18.

 278. First Bad Version

 You are a product manager and currently leading a team to develop a new product.

 Unfortunately, the latest version of your product fails the quality check.

 Since each version is developed based on the previous version,

 all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad

 one, which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether

 version is bad. Implement a function to find the first bad version.

 You should minimize the number of calls to the API.
 */
public class firstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    public int firstBadVersion1(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int med = lo + (hi -  lo)/2;
            if (isBadVersion(med)) {
                if (med == 1 || !isBadVersion(med-1))
                    return med;
                hi = med;
            } else {
                lo = med + 1;
            }
        }
        return -1; //no solution found.
    }

    private boolean isBadVersion(int num){
        return false;
    }
}
