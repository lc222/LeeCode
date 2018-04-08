package MSRA_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T016_Print {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        int cur=1, next=0;
        q.add(pRoot);
        while(!q.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();
            while(cur != 0){
                TreeNode tr = q.poll();
                cur --;
                tmp.add(tr.val);
                if(tr.left != null){
                    q.add(tr.left);
                    next ++;
                }
                if(tr.right != null){
                    q.add(tr.right);
                    next ++;
                }
            }

            res.add(new ArrayList(tmp));
            cur = next;
            next = 0;
        }
        return res;
    }
}
