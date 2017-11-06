package String;

/*

606. Construct String from Binary Tree

You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis

pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.


 */


public class tree2str {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    //89%
    public String tree2str(TreeNode t) {
        StringBuilder res = new StringBuilder();
        res = dfs(t, res);
        return res.toString();
    }

    public StringBuilder dfs(TreeNode t, StringBuilder res){
         StringBuilder tmp = res;
         if(t == null)
             return res;
         else
             tmp.append(t.val);

         if(t.left != null){
             tmp.append('(');
             tmp = dfs(t.left, tmp);
             tmp.append(')');
         }else if(t.right != null)
             tmp.append("()");

         if(t.right != null){
             tmp.append('(');
             tmp = dfs(t.right, tmp);
             tmp.append(')');
         }
         return tmp;
    }

    //40%
    public String tree2str1(TreeNode t) {
        if (t == null) return "";

        String result = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }

    //50%
    public static String tree2str2(TreeNode t) {
        if(t == null) return "";
        return dfs1(t).toString();
    }

    public static StringBuilder dfs1(TreeNode t) {
        if(t == null) return null;

        StringBuilder sb = new StringBuilder();
        sb.append(t.val);

        StringBuilder left = dfs1(t.left);
        StringBuilder right = dfs1(t.right);

        if(right == null && left == null) return sb;
        sb.append("(").append(left == null ? "" : left).append(")");
        if(right != null) sb.append("(").append(right).append(")");
        return sb;
    }
}

