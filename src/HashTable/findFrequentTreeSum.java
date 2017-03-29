package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findFrequentTreeSum {
	
	int maxCount = 0;
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> tmp = new HashMap<>();
    	dfs(root, tmp);
    	List<Integer> res = new ArrayList<>();
        for (int key : tmp.keySet()) {
            if (tmp.get(key) == maxCount) {
                res.add(key);
            }
        }
        
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    
    public int dfs(TreeNode node, HashMap<Integer, Integer> res){
    	if(node == null) return 0;
    	int left = 0, right = 0, sum = 0;
    	if(node.left != null)
    		left = dfs(node.left, res);
    	if(node.right != null)
    		right = dfs(node.right, res);
    	sum = left + right + node.val;
    	int count = res.getOrDefault(sum, 0) + 1;
		res.put(sum, count);
		maxCount = Math.max(maxCount, count);
    	return sum;
    }

    
}
