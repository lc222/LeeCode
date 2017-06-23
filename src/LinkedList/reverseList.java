package LinkedList;

/**
 * Created by liuchong on 2017/6/22.
 */
public class reverseList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur=head, next=head, pre=null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseList1(ListNode head){
        ListNode cur = head;
        return dfs(cur, null);
    }

    public static ListNode dfs(ListNode cur, ListNode pre){
        if(cur == null)
            return pre;
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
        return dfs(cur, pre);
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = null;
        reverseList1(head);
    }
}
