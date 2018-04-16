package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

/**
 95. Unique Binary Search Trees II

 Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 */

//https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31552/JAVA-DP-Solution-and-Brute-Force-Recursive-Solution.
public class generateTrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> [] dp = new List [n+1];
        dp[0] = new ArrayList<>();
        if(n == 0) return dp[0];
        dp[0].add(null);
        for(int i=1; i<=n; i++){
            dp[i] = new ArrayList<>();
            for(int j=0; j<i; j++){
                for(TreeNode left : dp[j]){
                    for(TreeNode right : dp[i-j-1]){
                        TreeNode tmp = new TreeNode(j+1);
                        tmp.left = left;
                        tmp.right = clone(right, j+1);
                        dp[i].add(tmp);
                    }
                }
            }
        }
        return dp[n];
    }

    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    public List<TreeNode> generateTrees1(int n) {
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int start,int end) {
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = generateTrees(start, i-1);
            List<TreeNode> right = generateTrees(i+1, end);
            for(TreeNode l : left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    trees.add(root);
                }
            }
        }
        return trees;
    }


    public static void main(String [] args){
        List<TreeNode> res = generateTrees(3);
        System.out.println(res.toString());
    }


}
