package LinkedList;

/**
 * Created by liuchong on 2017/7/13.
 */
public class addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode list1=l1, list2=l2;
        int len1=0, len2=0;
        while(list1 != null){
            list1 = list1.next;
            len1 ++;
        }

        while(list2 != null){
            list2 = list2.next;
            len2 ++;
        }

        list1 = l1;list2=l2;
        int flag = len1 > len2 ? dfs(list1, list2, len1-len2, res) :
                dfs(list2, list1, len2 - len1, res);
        if (flag == 1){
            res.val = 1;
            return res;
        }
        return res.next;

    }

    public static int dfs(ListNode l1, ListNode l2, int offset, ListNode res){

        if(offset > 0){
            res.next = new ListNode(0);
            res = res.next;
            int sum = l1.val + dfs(l1.next, l2, offset-1, res);
            res.val = sum % 10;
            return sum / 10;
        }else{
            if(l1 == null || l2 == null)
                return 0;

            res.next = new ListNode(0);
            res = res.next;
            int sum = l1.val + l2.val + dfs(l1.next, l2.next, offset, res);
            res.val = sum % 10;
            return sum / 10;

        }
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        ListNode head = new ListNode(1);
        // Make sure l1.length >= l2.length
        head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
        // Handle the first digit
        if (head.next.val > 9) {
            head.next.val = head.next.val % 10;
            return head;
        }
        return head.next;
    }
    // get length of the list
    public int getLength(ListNode l) {
        int count = 0;
        while(l != null) {
            l = l.next;
            count++;
        }
        return count;
    }
    // offset is the difference of length between l1 and l2
    public ListNode helper(ListNode l1, ListNode l2, int offset) {
        if (l1 == null) return null;
        // check whether l1 becomes the same length as l2
        ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
        ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
        // handle carry
        if (post != null && post.val > 9) {
            result.val += 1;
            post.val = post.val % 10;
        }
        // combine nodes
        result.next = post;
        return result;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1, l2);

    }
}
