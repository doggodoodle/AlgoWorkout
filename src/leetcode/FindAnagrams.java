package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ritvikmathur on 3/5/17.
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/?tab=Description
 */
public class FindAnagrams {

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams("ab","a"));

    }


    public List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length())
            return result;
        for (char c : p.toCharArray())
            chars[c-'a']++;
        System.out.println("s chars:"+Arrays.toString(chars));

        int start = 0, end = 0, count = p.length();

        // Go over the string
        while (end < s.length()) {
            // If the char at start appeared in p, we increase count
            if (end - start == p.length() && chars[s.charAt(start++)-'a']++ >= 0){
                System.out.println("start:"+start+ " end:"+end+ " count"+count);
                System.out.println("Increase count 1 for "+s.charAt(start));
                count++;
                System.out.println(Arrays.toString(chars));

            }

            // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
            if (--chars[s.charAt(end++)-'a'] >= 0){
                System.out.println("start:"+start+ " end:"+end+ " count"+count);
                System.out.println("Decrease count 1 for "+s.charAt(end));
                count--;
                System.out.println(Arrays.toString(chars));

            }

            if (count == 0)
                result.add(start);
        }

        return result;
    }

}
