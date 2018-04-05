package segment_tree;

import java.util.ArrayList;
import java.util.List;

/**

 315. Count of Smaller Numbers After Self

 You are given an integer array nums and you have to return a new counts array. The counts array has the property where

 counts[i] is the number of smaller elements to the right of nums[i].

 Example:

 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.
 Return the array [2, 1, 1, 0].
 */


public class countSmaller {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int count = 0;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] > nums[j])
                    count ++;
            }
            res.add(count);
        }
        return res;
    }

    class SegmentTreeNode{
        int start, end;
        SegmentTreeNode left, right;
        int count;
        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.count = 0;
        }
    }

    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        return res;
    }

}
