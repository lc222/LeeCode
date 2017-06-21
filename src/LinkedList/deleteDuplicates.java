package LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liuchong on 2017/6/21.
 */
public class deleteDuplicates {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;

        while(list != null) {
            if (list.next == null) {
                break;
            }
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        Set<Integer> s = new HashSet<>();
        ListNode cur = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        while(cur!=null){
            if(s.contains(new Integer(cur.val))){
                pre.next = cur.next;
            }else{
                s.add(new Integer(cur.val));
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode ss = new ListNode(1);
        head.next = ss;
        ss.next = null;
        //deleteDuplicates(head);
    }
}
