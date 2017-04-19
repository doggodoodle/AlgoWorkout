package leetcode.design;

import java.util.*;

/**
 * Created by ritvikmathur on 4/5/17.
 * https://leetcode.com/problems/design-twitter/#/description
 */
/*public class Twitter {
    public static void main(String[] args) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(1L, 1);
        map.put(3L, 2);
        map.put(2L, 3);
        for(Long ket : map.descendingKeySet()){
            System.out.println(map.get(ket));
        }
    }
}*/
public class Twitter {

    class User{
        public User(int userId){
            this.userId = userId;
        }
        int userId;
        Set<User> following = new HashSet<>();
        Set<User> followedBy = new HashSet<>();
        TreeMap<Long, Set<Tweet>> userFeedMap = new TreeMap<>();
        Map<Long, Set<Tweet>> userTweets = new TreeMap<>();

        /*public String toString() {
            return "User{" +
                   "userId=" + userId +
                   ", following=" + following +
                   ", followedBy=" + followedBy +
                   ", tweets=" + tweets +
                   '}';
        }*/

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return userId == user.userId;
        }

        @Override
        public int hashCode() {
            return userId;
        }
    }

    class Tweet{
        public Tweet(long ts, int tweetId, int userId){
            this.ts = ts;
            this.tweetId = tweetId;
            this.userId = userId;
        }
        long ts;
        int tweetId;
        int userId;
    }

    /*void printState(){
        System.out.println(users);
    }*/

    Map<Integer, User> users ;

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        long ts = System.nanoTime();
        Tweet tweet = new Tweet(ts, tweetId, userId);

        User user = users.get(userId);
        if(user == null){
            user = new User(userId);
            users.put(userId, user);
        }

        Set set = user.userFeedMap.get(ts);
        if(set==null){
            set = new HashSet();
            user.userFeedMap.put(ts, set);
        }
        set.add(tweet);

        Set set2 = user.userTweets.get(ts);
        if(set2==null){
            set2 = new HashSet();
            user.userTweets.put(ts, set2);
        }
        set2.add(tweet);

        for(User follower : user.followedBy){
            Set s = follower.userFeedMap.get(ts);
            if(s==null){
                s = new HashSet();
                follower.userFeedMap.put(ts,s);
            }
            s.add(tweet);
        }
        //printState();
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        //printState();

        User user = users.get(userId);
        if(user == null)
            return null;
        //System.out.println("user:"+userId+" tweets:"+user.tweets+" deleted:"+user.deleted);
        List<Integer> lastTen = new ArrayList<>();
        //int size = user.userFeedMap.size();
        //System.out.println("size:"+size);

        TreeMap<Long, Set<Tweet>> userFeed = user.userFeedMap;
        //System.out.println(userFeed.size()+"...");
        Iterator iterator = userFeed.descendingKeySet().iterator();

        //System.out.println(user.following.contains(1));

        while(lastTen.size()<=10 && iterator.hasNext()){

            Set<Tweet> tsSet = user.userFeedMap.get(iterator.next());
            for(Tweet tweet : tsSet){
                //System.out.println("tweet uid:"+tweet.userId+" tid:"+tweet.tweetId);
                boolean b1 = !(user.following.contains(users.get(tweet.userId)));
                boolean b2 = (userId != tweet.userId);
                //System.out.println(b1 +" : "+ b2);
               if( b1 && b2 )
                   continue;
                //System.out.println("sdf");
               lastTen.add(tweet.tweetId);
            }

            //System.out.println(lastTen.size() + " lastTen returned");

        }
        return lastTen;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

        User follower = users.get(followerId);
        if(follower == null){
            follower = new User(followerId);
            users.put(followerId, follower);
        }
        User followee = users.get(followeeId);
        if(followee == null){
            followee = new User(followeeId);
            users.put(followeeId, followee);
        }
        follower.following.add(followee);
        followee.followedBy.add(follower);

        follower.userFeedMap.putAll(followee.userTweets);
        //printState();
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        if(follower == null || followee == null){
            return;
        }
        follower.following.remove(followee);
        followee.followedBy.remove(follower);
        //printState();
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,1);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(2, 1);
        System.out.println(twitter.users.get(2).userFeedMap.size());
        System.out.println(twitter.getNewsFeed(2));

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
