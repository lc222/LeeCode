package LinkedList;

import java.util.HashSet;

/**
 * Created by liuchong on 2017/7/6.
 */
public class detectCycle {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> tmp = new HashSet<>();
        while(head != null){
            if(tmp.contains(head))
                return head;
            tmp.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle1 (ListNode head){
        ListNode cur=head, newHead=head;
        int i = 0;
        while(cur != null){
            for(int j=0; j<i; j++){
                if(cur == newHead)
                    return cur;
                newHead = newHead.next;
            }
            newHead = head;
            cur = cur.next;
            i += 1;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head){
        ListNode slow=head, fast=head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                ListNode tmp = head;
                while(tmp != slow){
                    tmp = tmp.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
