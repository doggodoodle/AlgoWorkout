package map;

import java.util.*;

/**
 * Created  on 12/31/16.
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("Cat", 3);
        treeMap.put("zebra", 4);
        treeMap.put("Apple", 2);
        System.out.println(treeMap);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"1");

        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(113);
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(13);
        System.out.println(treeSet.tailSet(14));
        System.out.println(treeSet.descendingSet().first());
    }
}
