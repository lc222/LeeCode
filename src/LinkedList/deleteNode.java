package LinkedList;

/**
 * Created by liuchong on 2017/6/20.
 */
public class deleteNode {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
