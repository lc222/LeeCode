package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
	Map<Integer, Set<Integer>> user;
	Map<Integer, LinkedList<Tweet>> post; 
	int count;
	
	class Tweet{
		int time;
		int id;
		
		Tweet(int time, int id){
			this.time = time;
			this.id = id;
		}
	}
	
    /** Initialize your data structure here. */
    public Twitter() {
        user = new HashMap<>();
        post = new HashMap<>();
        count = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	if(!user.containsKey(userId)) user.put(userId, new HashSet<>());
    	user.get(userId).add(userId);
    	if(!post.containsKey(userId)) post.put(userId, new LinkedList<>());
    	post.get(userId).addFirst(new Tweet(count++, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	if(!user.containsKey(userId)) return new LinkedList<Integer>();
    	PriorityQueue<Tweet> feed = new PriorityQueue<>((t1, t2) -> t2.time-t1.time);
    	user.get(userId).stream().filter(f -> post.containsKey(f)).forEach(f -> post.get(f).forEach(feed::add));
    	List<Integer> res = new LinkedList<>();
    	while(feed.size()>0 && res.size()<10) res.add(feed.poll().id);
    	return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!user.containsKey(followerId)) user.put(followerId, new HashSet<>());
        user.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if(user.containsKey(followerId) && followeeId != followerId) user.get(followerId).remove(followeeId);
    }
}
