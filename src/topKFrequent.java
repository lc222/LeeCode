import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequent {
	//我的。54ms
    public static List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> res = new ArrayList<>();
    	int max = 0;
    	Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
        	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        	max = Math.max(max, map.get(nums[i]));
        }
        List<Integer> [] maxNums = new ArrayList [max+1];
        for(Integer key:map.keySet()){
        	if(maxNums[map.get(key)] == null)
        		maxNums[map.get(key)] = new ArrayList<>();
        	maxNums[map.get(key)].add(key);        	
        }
        	
        for(int i=max; i>0 && k>0; --i){
        	if(maxNums[i] != null){
        		res.addAll(maxNums[i]);
        		k -= maxNums[i].size();
        	}
        }
        return res;
    }
    //网上找的，思路一样。28-32ms
    public List<Integer> topKFrequent1(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap();
        for (int i : nums)
            if (h.containsKey(i))
                h.put(i, h.get(i) + 1);
            else
                h.put(i, 1);
        
        List<Integer>[] fc = new ArrayList[n + 1];
        for (int i : h.keySet()) {
            int f = h.get(i);       //System.out.println(f + " times of " + i);
            if (fc[f] == null) fc[f] = new ArrayList();
            fc[f].add(i);
        }
        
        List<Integer> ans = new ArrayList();
        for (int i = n, j = 0; k > 0; k--) {
            for (; fc[i] == null || j == fc[i].size(); j = 0, i--);
            ans.add(fc[i].get(j++));
        }
        
        return ans;
    }
    
    //使用队列。但效率很低，只有5%
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else if (entry.getValue() > pq.peek().getValue()) {
                pq.poll();
                pq.offer(entry);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : pq) {
            result.add(entry.getKey());
        }

        return result;
    }
   
        
    public static void main(String[] args) {
    	int[] nums = {1};
    	topKFrequent(nums, 1);
    }
}
