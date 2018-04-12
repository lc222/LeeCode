package Tree;

import java.util.Stack;

/**

 112. Path Sum

 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along

 the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */


public class hasPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

     //99%
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum(root.left, sum - root.val)|| hasPathSum(root.right, sum - root.val);
    }

    //非递归方法
    public boolean hasPathSum2(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<> ();
        stack.push(root) ;
        while (!stack.isEmpty() && root != null){
            TreeNode cur = stack.pop() ;
            if (cur.left == null && cur.right == null){
                if (cur.val == sum ) return true ;
            }
            if (cur.right != null) {
                cur.right.val = cur.val + cur.right.val ;
                stack.push(cur.right) ;
            }
            if (cur.left != null) {
                cur.left.val = cur.val + cur.left.val;
                stack.push(cur.left);
            }
        }
        return false ;
    }
}
