import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by liuchong on 2017/3/27.
 */
public class mergeKLists {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
///
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }

    public ListNode mergeKLists1(ListNode[] lists){
         if(lists == null ||lists.length == 0)
             return null;
         return mergeKList(lists, 0, lists.length-1);
    }

    ListNode mergeKList(ListNode[] lists, int start, int end){
        if(start==end)
            return lists[start];
        else if(start < end){
            int mid = (end - start)/2 + start;
            ListNode left = mergeKList(lists, start, mid);
            ListNode right = mergeKList(lists, mid+1, end);
            return merge(left, right);
        }
        else
            return null;
    }

    ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}
