package com.chenlei.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 7. 给树节点加上pNext指针
 * @author chenlei
 * @since 2017 - 06 - 02 13:46
 */
public class PNext {

    //层序遍历添加兄弟指针
    private static void addPNext(BSTNode tree, Queue<BSTNode> queue) {
        queue.add(tree);
        int nextNullNum = 1;
        int currentNum = 0;
        BSTNode node = null;
        while(!queue.isEmpty()) {
            currentNum++;
            node = queue.poll();
            if(node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if(node.rightChild != null) {
                queue.add(node.rightChild);
            }
            if(currentNum == nextNullNum) {
                node.pNext = null;
                nextNullNum = nextNullNum * 2;
                currentNum = 0;
            } else {
                node.pNext = queue.element();
            }
        }
        if(node != null) {
            node.pNext = null;
        }
    }

    public static void main(String[] args) {
        BSTNode tree = BSTNode.initTree();
        addPNext(tree, new ArrayDeque<>());
        System.exit(0);
    }
}
