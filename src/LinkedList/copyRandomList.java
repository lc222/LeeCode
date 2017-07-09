package LinkedList;

import java.util.HashMap;

/**
 * Created by liuchong on 2017/7/7.
 */
public class copyRandomList {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode sec = new RandomListNode(cur.label);
            sec.next = cur.next;
            cur.next = sec;
            cur = cur.next.next;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        RandomListNode res = head.next;
        RandomListNode sec = res;
        while(sec.next != null){
            cur.next = cur.next.next;
            cur = cur.next;
            sec.next = sec.next.next;
            sec = sec.next;
        }
        cur.next = cur.next.next;
        return res;
    }

    public RandomListNode copyRandomList1(RandomListNode head){
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode cur = head;
        while(cur!= null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
