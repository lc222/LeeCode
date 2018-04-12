package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 113. Path Sum II
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */


public class pathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        help(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    public void help(TreeNode root, int sum, List<List<Integer>> res ,List<Integer> path){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(sum == root.val) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(root.val);
        help(root.left, sum - root.val, res, path);
        help(root.right, sum - root.val, res, path);
        path.remove(path.size()-1);
    }
}
