package LinkedList;

/**
 * Created by liuchong on 2017/7/13.
 */
public class partition {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode small=pre, cur=head, big=head;
        while(cur != null && cur.val < x){
            small = cur;
            cur = cur.next;
        }
        while(cur != null){
            if(cur.val < x){
                big.next = cur.next;
                cur.next = small.next;
                small.next = cur;
                small = cur;
                cur = big.next;
            }else {
                big = cur;
                cur = cur.next;
            }
        }
        return pre.next;
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        partition(head, 2);
    }
}
