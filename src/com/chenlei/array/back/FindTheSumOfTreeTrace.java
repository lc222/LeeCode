package com.chenlei.array.back;

import java.util.ArrayList;
import java.util.List;

/**
 *  2.2.1 寻找树中和为定值的所有路径
 * @author chenlei
 * @since 2016 - 11 - 19 12:08
 */
public class FindTheSumOfTreeTrace {

    private static void findTheTrace(Tree t, List<Tree> trace, int nowValue, int target) {
        if(t == null) {
            return;
        }
        if(t.leftChild == null && t.rightChild == null) {
            if(nowValue + t.value == target) {
                trace.add(t);
                printTrace(trace);
                trace.remove(trace.size() - 1);
            }
            return;
        }
        trace.add(t);
        findTheTrace(t.leftChild, trace, nowValue + t.value, target);
        findTheTrace(t.rightChild, trace, nowValue + t.value, target);
        trace.remove(trace.size() - 1);
    }

    public static void main(String[] args) {
        Tree tree = new Tree(10);
        Tree left1 = new Tree(5);
        Tree right1 = new Tree(12);
        Tree left21 = new Tree(4);
        Tree left22 = new Tree(7);
        tree.leftChild = left1;
        tree.rightChild = right1;
        left1.leftChild = left21;
        left1.rightChild = left22;
        findTheTrace(tree, new ArrayList<>(), 0, 22);
    }

    private static void printTrace(List<Tree> trace) {
        if(trace != null) {
            for(Tree tree : trace) {
                System.out.print(tree.value + " ");
            }
            System.out.println();
        }
    }

    private static class Tree {
        Tree(Integer value) {
            this.value = value;
        }
        Integer value;
        Tree leftChild;
        Tree rightChild;
    }

}


