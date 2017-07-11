package LinkedList;

/**
 * Created by liuchong on 2017/7/10.
 */
public class reverseBetween {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode sublisthead = new ListNode(0);
        ListNode sublisttail = new ListNode(0);
        int count = 1;
        ListNode pre_cur = dummyhead, cur = head;
        while(count <=n){
            ListNode temp = cur.next;
            if (count < m)
                pre_cur = cur;
            else if (count == m){
                sublisttail = cur;
                sublisthead.next = cur;
            }else if (count > m){
                cur.next = sublisthead.next;
                sublisthead.next = cur;
            }
            cur = temp;
            ++count;
        }
        pre_cur.next = sublisthead.next;
        sublisttail.next = cur;
        return dummyhead.next;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if(head == null || m == n)
            return head;
        int [] seq = new int[n-m+1];
        ListNode start = head;
        ListNode temp = head;
        int i = 1;
        while(i<m){
            start = start.next;
            i++;
        }
        temp = start;
        seq[0] = temp.val;
        int j=1;
        while(i<n){
            temp = temp.next;i++;
            seq[j++] = temp.val;
        }

        for(j = n-m;j>=0;j--){
            start.val = seq[j];
            start = start.next;
        }
        return head;

    }
}
