package com.chenlei.tree;

import util.NumberUtils;
import util.tuple.Tuple;
import util.tuple.Tuple2;

/**
 *  4. 求二叉树中结点的最大距离
 * @author chenlei
 * @since 2017 - 06 - 01 15:09
 */
public class MaxDistanceInBinaryTree {

    //<maxDistance, depth> 避免重复计算
    private static Tuple2<Integer, Integer> getMaxDistanceOfBinaryTree(BSTNode tree) {
        if(tree == null) {
            return Tuple.of(0, 0);
        }
        Tuple2<Integer, Integer> leftInfo = getMaxDistanceOfBinaryTree(tree.leftChild);
        Tuple2<Integer, Integer> rightInfo = getMaxDistanceOfBinaryTree(tree.rightChild);
        int maxDistance = NumberUtils.maxOfThree(leftInfo._1().orElse(0), rightInfo._1().orElse(0), leftInfo._2().orElse(0) + rightInfo._2().orElse(0));
        return Tuple.of(maxDistance, NumberUtils.max(leftInfo._2().orElse(0), rightInfo._2().orElse(0)) + 1);
    }


    public static void main(String[] args) {
        BSTNode bst = BSTNode.initTree();
        System.out.println(getMaxDistanceOfBinaryTree(bst));
    }
}
