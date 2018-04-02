package com.chenlei.tree;

import util.NumberUtils;

/**
 * 5. 求树的深度
 * @author chenlei
 * @since 2017 - 06 - 01 10:01
 */
public class DepthOfTree {

    private static int getDepthOfTree(BSTNode tree) {
        if(tree == null) {
            return 0;
        }
        return NumberUtils.max(getDepthOfTree(tree.leftChild), getDepthOfTree(tree.rightChild)) + 1;
    }

    public static void main(String[] args) {
        BSTNode bst = BSTNode.initTree();
        System.out.println(getDepthOfTree(bst));
    }
}
