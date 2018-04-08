package MSRA_100;

import java.util.List;

public class T013_lastKNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        int i=0;
        ListNode cur = head, second = head;
        while(cur.next != null){
            i++;
            cur = cur.next;
            if(i>=k)
                second = second.next;
        }
        if(i > k)
            return null;
        return second;
    }
}
