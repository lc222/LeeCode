package HashTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {
 	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.empty()){
        	while(cur != null){
        		stack.add(cur);
        		cur = cur.left;
        	}
        	cur = stack.pop();
        	list.add(cur.val);
        	cur = cur.right;
        }
        return list;
    }
    

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // method 1: recursion

        helper(root, res);
        return res;
    }
    //helper function for method 1
    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
           }
       }
   }
}
