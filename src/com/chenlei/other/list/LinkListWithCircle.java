package com.chenlei.other.list;

/**
 *  判断一个单链表是否有环
 * @author chenlei
 * @since 2017 - 06 - 17 11:24
 */
public class LinkListWithCircle {

    //快慢指针，一个走一步，一个走两步
    private static boolean withCircle(Node list) {
        Node fastPointer = list, slowPointer = list;
        while (fastPointer.pNext != null && fastPointer.pNext.pNext != null) {
            fastPointer = fastPointer.pNext.pNext;
            slowPointer = slowPointer.pNext;
            if(fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node4 = new Node(4, null);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        node4.pNext = node2;
        System.out.println(withCircle(node1));
    }


}
