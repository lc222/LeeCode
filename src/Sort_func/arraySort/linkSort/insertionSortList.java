package Sort_func.arraySort.linkSort;

/**
 * Created by liuchong on 2017/7/3.
 */
public class insertionSortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode insertionSortList(ListNode head){
        if(head == null)
            return head;
        ListNode newHead = new ListNode(0);
        ListNode cur=head, pre=newHead, next;
        while(cur != null){
            next = cur.next;
            while(pre.next != null && pre.next.val < cur.val)
                pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = newHead;
            cur = next;
        }
        return newHead.next;
    }

    public static ListNode insertionSortList2(ListNode head){
        if(head == null)
            return head;
        ListNode newHead = new ListNode(0);
        ListNode cur=head, pre=newHead, next;
        while(cur != null){
            next = cur.next;
            if(pre != newHead && pre.val > cur.val)
                pre = newHead;
            while(pre.next != null && pre.next.val < cur.val)
                pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return newHead.next;
    }

    public ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode sortedHead = head, sortedTail = head;
        head = head.next;
        sortedHead.next = null;

        while (head != null)
        {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            // new val is less than the head, just insert in the front
            if (temp.val <= sortedHead.val)
            {
                temp.next = sortedHead;
                sortedTail = sortedHead.next == null ? sortedHead : sortedTail;
                sortedHead = temp;
            }
            // new val is greater than the tail, just insert at the back
            else if (temp.val >= sortedTail.val)
            {
                sortedTail.next = temp;
                sortedTail = sortedTail.next;
            }
            // new val is somewhere in the middle, we will have to find its proper
            // location.
            else
            {
                ListNode current = sortedHead;
                while (current.next != null && current.next.val < temp.val)
                {
                    current = current.next;
                }

                temp.next = current.next;
                current.next = temp;
            }
        }

        return sortedHead;
    }

}
