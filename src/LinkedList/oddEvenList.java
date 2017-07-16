package LinkedList;

/**
 * Created by liuchong on 2017/7/15.
 */
public class oddEvenList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode ji=head, sec=head.next, ou = sec;
        while(ji.next != null && ou.next != null){
            ji.next = ou.next;
            ou.next = ji.next.next;
            ji = ji.next;
            ou = ou.next;
        }
        if(ou != null)
            ou.next = null;
        ji.next = sec;
        return head;
    }


}
