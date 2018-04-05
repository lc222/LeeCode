package MSRA_100;

public class T001_TreeToList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode TreeToList(TreeNode root){
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return root;
        TreeNode left = TreeToList(root.left);
        TreeNode p = left;
        while(p != null && p.right != null)
            p = p.right;
        if(left != null){
            left.right = root;
            root.left = p;
        }

        TreeNode right = TreeToList(root.right);
        if(right != null){
            right.left = root;
            root.right = right;
        }

        return left != null ? left : root;
    }
}
