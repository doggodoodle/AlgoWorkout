package bbg;

import org.junit.Assert;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/*
* aaa = t
* aabb = t
* aabbc = t
* aabbccc = t
* aabbccddd = t
*
* abbccc = f
* aaabbbcc = f
* aabbcccc = f
* */
public class CoolString {



    public static void main(String[] args) {
        runTests();
        //System.out.println(isCoolOrCanBeMadeCool("aaabbbcc"));
    }

    private static void runTests() {
        Assert.assertTrue(isCoolOrCanBeMadeCool("aaa"));
        Assert.assertTrue(isCoolOrCanBeMadeCool("aabb"));
        Assert.assertTrue(isCoolOrCanBeMadeCool("aabbc"));
        Assert.assertTrue(isCoolOrCanBeMadeCool("aabbccc"));
        Assert.assertTrue(isCoolOrCanBeMadeCool("aabbccddd"));

        Assert.assertFalse(isCoolOrCanBeMadeCool("abbccc"));
        Assert.assertFalse(isCoolOrCanBeMadeCool("aaabbbcc"));
        Assert.assertFalse(isCoolOrCanBeMadeCool("aabbcccc"));

        System.out.println("All Tests Pass!");
    }

    private static boolean isCoolOrCanBeMadeCool(String s) {

        Map<Character, AtomicInteger> freqMap = new HashMap<>();

        Map<Integer, AtomicInteger> countMap = new HashMap<>();

        s.chars().forEach(ch -> {
                    char c = (char) ch;
                    freqMap.computeIfAbsent(c, v -> new AtomicInteger(0)).getAndIncrement();
                }
        );
        freqMap.values().forEach( freq -> {
            countMap.computeIfAbsent(freq.intValue(), v -> new AtomicInteger(0)).getAndIncrement();
        });

        if (countMap.size() > 2) {
            return false;
        }
        else if (countMap.size() < 2) {
            return true;
        }
        else {
            int maxFreq = Collections.max(countMap.keySet());
            int minFreq = Collections.min(countMap.keySet());

            int diff = countMap.get(maxFreq).intValue() - countMap.get(minFreq).intValue();
            if (diff > 1 ) {
                return false;
            }
            else if (diff < 0 && maxFreq-minFreq > 1) {
                return false;
            }
        }
//        System.out.println(freqMap);
//        System.out.println(countMap);
        return true;

    }

}
