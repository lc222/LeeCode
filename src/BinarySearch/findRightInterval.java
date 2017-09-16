package BinarySearch;

/*

436. Find Right Interval

Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
Example 1:
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
 */

import java.util.Arrays;
import java.util.HashMap;

public class findRightInterval {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public static int[] findRightInterval(Interval[] intervals) {
        int [] starts = new int[intervals.length];
        int [] ends = new int[intervals.length];
        HashMap<Integer, Integer> start = new HashMap<>();
        for(int i=0; i<intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
            start.put(intervals[i].start, i);
        }

        Arrays.sort(starts);

        int [] res = new int[intervals.length];

        for(int i=0; i<intervals.length; i++){
            int target = ends[i];
            if(target > starts[intervals.length-1]) {
                res[i] = -1;
                continue;
            }
            int left=0, right=intervals.length-1, mid;
            boolean flag = false;
            while(left <= right){
                mid = (left+right)/2;
                if(starts[mid] == target) {
                    res[i] = start.get(target);
                    flag = true;
                    break;
                }
                else if(starts[mid] > target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            if(!flag)
                res[i] = start.get(starts[left]);
        }
        return res;
    }

    public static void main(String[] args){
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(4, 5);
        intervals[1] = new Interval(2, 3);
        intervals[2] = new Interval(1, 2);
        findRightInterval(intervals);
    }
}
