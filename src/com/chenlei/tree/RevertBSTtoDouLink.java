package com.chenlei.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  2. 把二叉查找树转变成有序的双向链表
 * @author chenlei
 * @since 2017 - 05 - 31 11:38
 */
public class RevertBSTtoDouLink {

    //中序遍历添加到list
    private static void inOrder(BSTNode tree, List<BSTNode> list) {
        if(tree != null) {
            inOrder(tree.leftChild, list);
            list.add(tree);
            inOrder(tree.rightChild, list);
        }
    }

    public static void main(String[] args) {
        BSTNode bst = BSTNode.initTree();
        List<BSTNode> list = new ArrayList<>();
        inOrder(bst, list);
        for(int i = 0; i < list.size(); i++) {
            list.get(i).leftChild = (i == 0 ? null : list.get(i -1));
            list.get(i).rightChild = (i == list.size() - 1 ? null : list.get(i+1));
        }
        for(BSTNode node : list) {
            System.out.println(node.value);
        }
    }

}
