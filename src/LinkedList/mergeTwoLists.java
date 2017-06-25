package LinkedList;

/**
 * Created by liuchong on 2017/6/24.
 */
public class mergeTwoLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode l3 = res;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l3.next = l1;
                l1 = l1.next;
                l3 = l3.next;
            }else{
                l3.next = l2;
                l2 = l2.next;
                l3 = l3.next;
            }
        }

        if(l1 == null){
            l3.next = l2;
        }else if(l2 == null)
            l3.next = l1;

//        while(l1!=null){
//            l3.next = l1;
//            l1 = l1.next;
//            l3 = l3.next;
//        }
//
//        while(l2!=null){
//            l3.next = l2;
//            l2 = l2.next;
//            l3 = l3.next;
//        }
        return res.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists1(l1.next, l2);
        }else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists1(l1, l2.next);
        }
        return mergeHead;
    }
}
