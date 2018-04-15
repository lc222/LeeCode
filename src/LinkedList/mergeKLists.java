package LinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by liuchong on 2017/7/16.
 * question:
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * 将K个有序链表进行merge，并返回最终结果。
 */
public class mergeKLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists){
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

    public ListNode mergeKLists1(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
