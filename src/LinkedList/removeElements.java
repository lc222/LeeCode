package LinkedList;

/**
 * Created by liuchong on 2017/6/22.
 */
public class removeElements {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode tmp = head;
        while(tmp != null && tmp.next != null){
            if(tmp.val == val) {
                tmp.val = tmp.next.val;
                tmp.next = tmp.next.next;
            }else
                tmp = tmp.next;
        }
        if(tmp != null && tmp.val == val)
            tmp = null;
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) return null;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.val == val) pointer.next = pointer.next.next;
            else pointer = pointer.next;
        }
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements4(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }

    public static void main(String[] args){
        ListNode root = new ListNode(1);
        ListNode s = new ListNode(6);
        root.next = s;
        s.next = new ListNode(3);
        s.next.next = new ListNode(6);

        removeElements(root, 6);
    }
}
