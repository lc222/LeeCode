package LinkedList;

import java.util.HashMap;

/**
 * Created by liuchong on 2017/7/5.
 */
public class reorderList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
            return;
        ListNode fast=head, slow=head, second;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        second = slow.next;
        slow.next = null;

        ListNode pre=null, next;
        while(second != null){
            next = second.next;
            second.next = pre;
            pre = second;
            second =  next;
        }

        fast = head;
        while(pre!=null){
            next = pre;
            pre = pre.next;
            next.next = fast.next;
            fast.next = next;
            fast = fast.next.next;
        }
    }

    public void reorderList1(ListNode head) {

        HashMap<Integer, ListNode> nodeMap = new HashMap<>();
        int len = 0;
        ListNode p = head;

        while (p != null) {
            nodeMap.put(len++, p);
            p = p.next;
        }


        int i = 0;
        int j = len - 1;
        for (; i < j - 1; ++i, --j) {
            ListNode tmp = nodeMap.get(i).next;
            nodeMap.get(i).next = nodeMap.get(j);
            nodeMap.get(j).next = tmp;
            nodeMap.get(j - 1).next = null;

        }
    }

}
