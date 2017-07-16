package LinkedList;

/**
 * Created by liuchong on 2017/7/16.
 */
public class swapPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public ListNode swapPairs(ListNode head) {
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode cur = pHead, next;
        while(head != null && head.next != null){
            next = head.next;
            head.next = next.next;
            cur.next = next;
            next.next = head;cur = head;
            head = head.next;
        }
        return pHead.next;
    }

    public ListNode swapPairs1(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs1(head.next.next);
        n.next = head;
        return n;
    }
}
