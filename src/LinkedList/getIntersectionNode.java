package LinkedList;

/**
 * Created by liuchong on 2017/6/21.
 */
public class getIntersectionNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA, B=headB;
        while(A != null){
            while(B != null){
                if(A == B)
                    return A;
                else
                    B = B.next;
            }
            B = headB;
            A = A.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA=0, lenB=0;
        ListNode A=headA, B=headB;
        while(A != null){
            lenA ++;
            A = A.next;
        }

        while(B != null) {
            lenB++;
            B = B.next;
        }
        A = headA;
        B=headB;

        while(lenA > lenB){
            A = A.next;
            lenA --;
        }
        while(lenA < lenB){
            B = B.next;
            lenB --;
        }

        while(A != B){
            A = A.next;
            B = B.next;
        }

        return A;


    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}
