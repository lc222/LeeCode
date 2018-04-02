package com.chenlei.tree;

import util.NumberUtils;

/**
 * 6. 树结点的移动
 * @author chenlei
 * @since 2017 - 06 - 02 15:36
 */
public class MoveNode {

    private static int steps = 0;

    /**
     * 将所有子树的多余石头或者亏欠都移动到tree的根节点。return值为根节点多余或亏欠的值
     */
    private static int moveNode(BSTNode tree) {
        if(tree == null) {
            return 0;
        }
        int leftNodes = moveNode(tree.leftChild);
        int rightNodes = moveNode(tree.rightChild);
        steps = steps + NumberUtils.abs(leftNodes) + NumberUtils.abs(rightNodes);
        return tree.stone + leftNodes + rightNodes - 1;
    }

    public static void main(String[] args) {
        BSTNode tree = BSTNode.initTree();
        moveNode(tree);
        System.out.println(steps);
    }
}
