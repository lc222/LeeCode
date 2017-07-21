package BinarySearch;

/**
 * Created by liuchong on 2017/7/18.
 */
public class twoSum {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0)
            return new int [2];

        int start = 0, end = numbers.length-1;
        while(start < end){
            if(numbers[start] + numbers[end] == target)
                return new int[]{start+1, end+1};
            else if(numbers[start] + numbers[end] > target)
                end = largestSmallerOrLastEqual(numbers, start, end, target);
            else
                start = smallestLargerOrFirstEqual(numbers, start, end, target);
        }
        return new int [2];

    }

    private int largestSmallerOrLastEqual(int [] numbers, int start, int end, int target){
        int left = start, right = end;
        while(left <= right){
            int mid = (left + right)/2;
            if(numbers[mid] > target)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }

    private int smallestLargerOrFirstEqual(int [] numbers, int start, int end, int target){
        int left = start, right = end;
        while(left <= right){
            int mid = (left + right)/2;
            if(numbers[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }

}
