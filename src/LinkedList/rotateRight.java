package LinkedList;

/**
 * Created by liuchong on 2017/6/25.
 */
public class rotateRight {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode newHead=head, secHead=head;
        int len=1, i = 1;
        while(newHead.next != null){
            newHead = newHead.next;
            len ++;
        }
        newHead = head;
        while(head != null){
            if(head.next == null)
                return newHead;
            if(i == len - k%len){
                secHead = head.next;
                head.next = null;
                break;
            }else{
                head = head.next;
            }
        }

        ListNode secHead2 = secHead;
        while(secHead2.next != null)
            secHead2 = secHead2.next;
        secHead2.next = newHead;
        return secHead;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if(head==null||head.next==null||k==0) return head;

        //make it a cricle, break from k postion far from the head
        ListNode index=head; int len=1;// int len to record the length of list
        while(index.next!=null)
        {index=index.next; len++;}
        index.next=head;

        for(int i=0;i<len-k%len;i++)
        {
            index=index.next;
        }
        ListNode result=index.next;
        index.next=null;
        return result;
    }
}
