package LinkedList;

/**
 * Created by liuchong on 2017/7/17.

 Given a linked list, reverse the nodes of a linked list k at a time
 and return its modified list. k is a positive integer and is less than
 or equal to the length of the linked list.
 If the number of nodes is not a multiple of k then
 left-out nodes in the end should remain as it is.
 You may not alter the values in the nodes,
 only nodes itself may be changed. Only constant memory is allowed.
 For example,
 Given this linked list: 1->2->3->4->5
 For k = 2, you should return: 2->1->4->3->5
 For k = 3, you should return: 3->2->1->4->5

 其实就是将链表每k个元素进行一次翻转，最后剩下的元素如果不足k个，就保持原顺序
 */
public class reverseKGroup {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head, next=head;
        int i=0;
        while(next != null && i < k){
            next = next.next;
            i++;
        }
        if(i < k)
            return head;
        ListNode pre = reverseKGroup(next, k);
        while(k -- > 0){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev, start, then, tail;
        tail = prev = newHead;
        start = prev.next;
        while (true) {
            // check if there's k nodes left-out
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null)
                    return newHead.next;
            }
            // reverse k nodes
            for (int i = 0; i < k - 1; i++) {
                then = start.next;
                start.next = then.next;
                then.next = prev.next;
                prev.next = then;
            }
            tail = prev = start;
            start = prev.next;
        }
    }
}
