package LinkedList;

/**
 * Created by liuchong on 2017/7/16.
 */
public class removeNthFromEnd {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head, fast=head;
        int i = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            i += 1;
        }
        if(fast == null) { // 总长度为2*i
            while(i-- > n+1)
                slow = slow.next;
        }else{ //总长度为2*i+1
            while(i -- > n)
                slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
