package leetcode;

import java.util.*;

/**
 * Created  on 4/6/17.
 */
public class RandomizedSet {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        double ran = Math.random();

        int in = (int) (ran*1000000000);

        int r = in & set.size();

        System.out.println("r:"+r);

        System.out.println(set.toArray()[r-1]);



    }
}
