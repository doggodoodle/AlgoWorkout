package twosigma;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ritvikmathur on 5/29/17.
 *
 * longest chain
 given a set of words. for any word, delete one char, if the new word is
 still in the words set.
 The chain could increase by one. Do more delete rounds on the word to
 get the max size of the chain.
 return the longest chain for all the words.

 i.e.
 (a, abcd, bcd, abd, cd, c)
 the longest chain should be abcd->bcd->cd->c

 (a, abcd, acd, bcd, abd, cd, c, d)
 abcd->bcd->cd->c
 abcd->acd->cd->d
 abcd->acd-cd->c

 */
public class LongestChain {
    public static void main(String[] args) {
        LongestChain longestChain = new LongestChain();
        Set<String> set = new HashSet<>();

        set.add("abcd");
        set.add("a");
        set.add("bcd");
        set.add("abd");
        set.add("cd");
        set.add("c");

        int[] max = new int[1];
        max[0] = 0;
        List<String> longest = new ArrayList<>();

        for(String s: set){
            longestChain.find(set, max, s, new ArrayList<String>(), longest);
        }

        System.out.println("Longest: "+longest);

    }

    void find(Set<String> set, int[] max, String s, List<String> visited, List<String> longest){
        if(set.contains(s)){
            visited.add(s);
            if(visited.size()>max[0]) {
                longest.clear();
                longest.addAll(visited);
                max[0] = visited.size();
            }
        }
        else
            return;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if(j==i)
                    continue;
                sb.append(s.charAt(j));
            }
            if(sb.length()>0)
                find(set, max, sb.toString(), new ArrayList<>(visited), longest);
        }
    }
}
