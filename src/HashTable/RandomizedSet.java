package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
	ArrayList<Integer> nums = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>(); //stores indices
    /** Initialize your data structure here. */
    public RandomizedSet() {
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            nums.add(val);
            map.put(val, nums.size()-1);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int last = nums.get(nums.size()-1);
            int removePos = map.get(val);
            nums.set(removePos, last); //replace the removed number with the last number
            nums.remove(nums.size()-1); //always remove the last element, takes O(1)
            map.put(last, removePos); //upadate index
            map.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = (int)(Math.random() * nums.size());
        return nums.get(index);
    }
}