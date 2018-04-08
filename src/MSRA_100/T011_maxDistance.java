package MSRA_100;

public class T011_maxDistance {

    //方法一，Node定义只有左右节点，不包含深度
    class Node {
        int data;
        Node left;
        Node right;

        Node(int value) {
            this.data = value;
        }
    }

    int maxLen = 0;

    public int maxDistance(Node root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 0;

        int leftMaxLen = maxDistance(root.left) + 1;
        int rightMaxLen = maxDistance(root.right) + 1;

        int maxTempLen = leftMaxLen + rightMaxLen;
        if(maxTempLen > maxLen)
            maxLen = maxTempLen;
        return Math.max(leftMaxLen, rightMaxLen);
    }


    //方法二，每个节点定义包含其深度
    class Node1 {
        int data;
        Node1 left;
        Node1 right;
        int maxLeftLen;   // 从该节点向左走，最大距离
        int maxRightLen;  // 从该节点向右走，最大距离

        Node1(int value) {
            this.data = value;
        }
    }

    // findMaxLen能够计算出每个节点的左右子树的最大距离，并将该值+1保存在该节点的maxLeftLen和maxRightLen中
    public void findMaxLen(Node1 node) {
        if (node == null)
            return;

        // 如果该节点的左子树为空，则该从该节点向左走的最长距离为0
        if (node.left == null) {
            node.maxLeftLen = 0;
        }
        // 如果该节点的右子树为空，则该从该节点向右走的最长距离为0
        if (node.right == null) {
            node.maxRightLen = 0;
        }

        // 如果该节点的左子树不为空，递归的计算出该节点的左孩子节点的maxLeftLen和maxRightLen（并更新maxLen）
        if (node.left != null) {
            findMaxLen(node.left);
        }

        // 如果该节点的右子树不为空，递归的计算出该节点的右孩子节点的maxLeftLen和maxRightLen（并更新maxLen）
        if (node.right != null) {
            findMaxLen(node.right);
        }

        // 如果该节点的左子树不为空，那么该节点的maxLeftLen等于它的左孩子节点的maxLeftLen、maxRightLen中较大的那个 + 1
        if (node.left != null) {
            int maxLeftLenTemp =  Math.max(node.left.maxLeftLen, node.left.maxRightLen) + 1;
            node.maxLeftLen = maxLeftLenTemp;
        }
        // 如果该节点的右子树不为空，那么该节点的maxRightLen等于它的右孩子节点的maxLeftLen、maxRightLen中较大的那个 + 1
        if (node.right != null) {
            int maxRightLenTemp =  Math.max(node.right.maxLeftLen, node.right.maxRightLen) + 1;
            node.maxRightLen = maxRightLenTemp;
        }
        // 到这一步，当前处理的节点的maxLeftLen和maxLeftLen已经得到了，如果它的maxLeftLen+maxRightLen值比maxLen大，就可以更新maxLen
        if (maxLen < node.maxLeftLen + node.maxRightLen) {
            maxLen = node.maxLeftLen + node.maxRightLen;
        }
    }
}
