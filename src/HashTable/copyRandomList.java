package HashTable;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
 };
public class copyRandomList {
	
    public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode node = head;
    	Map<RandomListNode, RandomListNode> map = new HashMap<>();
    	while(node != null){
    		map.put(node, new RandomListNode(node.label));
    		node = node.next;
    	}
    	
    	node = head;
    	while(node != null){
    		map.get(node).next = map.get(node.next);
    		map.get(node).random = map.get(node.random);
    		node = node.next;
    	}
    	return map.get(head);
    }
    
    public static RandomListNode copyRandomList1(RandomListNode head) {
		RandomListNode iter = head, next;
	
		// First round: make copy of each node,
		// and link them together side-by-side in a single list.
		while (iter != null) {
			next = iter.next;
	
			RandomListNode copy = new RandomListNode(iter.label);
			iter.next = copy;
			copy.next = next;
	
			iter = next;
		}
	
		// Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}
	
		// Third round: restore the original list, and extract the copy list.
		iter = head;
		RandomListNode pseudoHead = new RandomListNode(0);
		RandomListNode copy, copyIter = pseudoHead;
	
		while (iter != null) {
			next = iter.next.next;
	
			// extract the copy
			copy = iter.next;
			copyIter.next = copy;
			copyIter = copy;
	
			// restore the original list
			iter.next = next;
	
			iter = next;
		}
	
		return pseudoHead.next;
	}
    
    public static void main(String[] args) {
    	RandomListNode test = new RandomListNode(1);
    	RandomListNode test2 = new RandomListNode(2);
    	test.next = test2;
    	test.random = test2;
    	test2.next = null;
    	test2.random = test2;
    	copyRandomList1(test);
    }

}
