package LinkedList;

/**
 * Created by liuchong on 2017/6/20.
 */
public class hasCycle {

     class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    public boolean hasCycle(ListNode head) {
        ListNode fast=head, slow=head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

//其实题目一个最直观的理解就是，一直遍历链表，如果不存在环，那么一定会碰到null指针。
    //但是一个严重的问题就是如果有环，将会死循环。
    //所以接下来这种方法就是巧妙的解决了死循环的问题
    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode node = head;
        while(node != null) {

            if(node.next == head) {
                return true;
            }

            ListNode temp = node.next;
            node.next = head;
            node = temp;
        }

        return false;
    }



}
