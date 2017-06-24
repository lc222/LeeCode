package LinkedList;

/**
 * Created by liuchong on 2017/6/23.
 */
public class isPalindrome {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode end = null, cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = end;
            end = cur;
            cur = tmp;
        }

        while(end != null){
            if(head.val != cur.val)
                return false;
            cur = cur.next;
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome1(ListNode head) {
        ListNode fast=head, slow=head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果链表长度为奇数
        if(fast != null) slow = slow.next;

        ListNode end=null, tmp;
        while(slow != null){
            tmp = slow.next;
            slow.next = end;
            end = slow;
            slow = tmp;
        }

        while(end != null){
            if(end.val != head.val)
                return false;
            end = end.next;
            head = head.next;
        }

        return true;
    }

    ListNode h;
    public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;

        if (h == null) h = head;

        boolean tmp = true;
        if (head.next != null) tmp &= isPalindrome2(head.next);

        tmp &= (head.val == h.val);
        h = h.next;
        return tmp;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        isPalindrome(head);
    }
}
