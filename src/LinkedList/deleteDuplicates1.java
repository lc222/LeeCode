package LinkedList;

/**
 * Created by liuchong on 2017/7/13.
 */
public class deleteDuplicates1 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur=head, left=pre;
        while(cur != null && cur.next != null){
            if(cur.val != cur.next.val){
                left = cur;
                cur = cur.next;
            }else{
                while(cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
                left.next = cur.next;
                cur = cur.next;
            }
        }
        return pre.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
