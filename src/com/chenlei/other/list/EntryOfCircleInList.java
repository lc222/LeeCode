package com.chenlei.other.list;

/**
 *  寻找有环链表中环的起点
 * @author chenlei
 * @since 2017 - 06 - 17 11:34
 */
public class EntryOfCircleInList {

    private static int getTheEntry(Node list) {
        Node fastPointer = list, slowPointer = list;
        while (true) {
            fastPointer = fastPointer.pNext.pNext;
            slowPointer = slowPointer.pNext;
            if(fastPointer == slowPointer) {
                break;
            }
        }
        slowPointer = list;
        //之后每次只走一步
        while (fastPointer != slowPointer) {
            fastPointer = fastPointer.pNext;
            slowPointer = slowPointer.pNext;
        }
        return fastPointer.value;
    }

    public static void main(String[] args) {
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        node4.pNext = node2;
        System.out.println(getTheEntry(node1));
    }
}
