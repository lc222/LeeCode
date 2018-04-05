package MSRA_100;

import java.util.Stack;

public class T007_ListJoined {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //第一种方法使用两个栈，然后同时弹出最后一个元素
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        while(pHead1 != null){
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null){
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode res = null;
        while(!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()){
            s1.pop();
            res = s2.pop();
        }
        return res;
    }

    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        //第二种方法直接遍历，使用快慢两个指针
        int length1=0, length2=0;
        ListNode n1 = pHead1, n2= pHead2;
        while(n1 != null){
            length1++;
            n1 = n1.next;
        }
        while(n2 != null){
            length2++;
            n2 = n2.next;
        }
        n1 = pHead1;
        n2 = pHead2;
        int dif = length1>length2?length1-length2:length2-length1;
        if(length1 > length2){
            for(int i=0; i<dif; i++)
                n1 = n1.next;
        }else
            for(int i=0; i<dif; i++)
                n2 = n2.next;
        while(n1 != null && n2 != null && n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }
}
