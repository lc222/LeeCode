package MSRA_100;

import java.util.ArrayList;

public class T004_FindPath {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {this.val = val;}
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        ArrayList<Integer> path = new ArrayList<>();
        int sum = 0;
        dfs(root, res, path, sum, target);
        return res;
    }

    public void dfs(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int sum, int target){
        if(root == null)
            return;
        sum += root.val;
        //说明已经是叶节点，判断sum是否等于target，如果等于则将path添加到res
        if(root.left == null && root.right == null){
            if(sum == target){
                path.add(root.val);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return;
        }else{
            path.add(root.val);
            dfs(root.left, res, path, sum, target);
            dfs(root.right, res, path, sum, target);
            path.remove(path.size()-1);
        }
    }
}
