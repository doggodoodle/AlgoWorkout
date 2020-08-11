package fb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WildCardWordLookup {

    public static class Node {
        Character val;
        Map<Character, Node> children;
        boolean isEnd = false;
        public Node (Character val) {
            this.val = val;
            children = new HashMap<>();
        }
        public Node () {
            this.val = '*';
            children = new HashMap<>();
        }
    }

    Node root = new Node();

    public void add(List<String> list) {
        for (String word : list) {
            add(word);
        }
    }

    public void add(String word) {
        Node n = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!n.children.containsKey(c)) {
                n.children.put(c, new Node(c));
            }
            n = n.children.get(c);
            if (i == word.length() -1) {
                n.isEnd = true;
            }
        }
    }

    public boolean get(String s) {
        return get(s, 0, root);
    }

    public static boolean get(String s, int i, Node n) {
        if (i >= s.length()) {
            return n.isEnd;
        }
        char c = s.charAt(i);
        if (c == '*') {
            boolean res = false;
            for (Node n1 : n.children.values()) {
                res = res || get(s, i + 1, n1);
            }
            return res;
        } else {
            if (n.children.containsKey(c)) {
                n = n.children.get(c);
                if (i == s.length()-1 && c == n.val) {
                    return n.isEnd;
                }
            } else {
                return false;
            }
        }
        return get(s, i + 1, n);
    }

    public static void main(String[] args) {
        WildCardWordLookup lookup = new WildCardWordLookup();
        lookup.add(Arrays.asList("abc", "azk", "bqc"));
        System.out.println("****************");
        String s = "abc";
        System.out.println(lookup.get(s) ? "Passed" : "Failed!!! " + s);
        s = "a*c";
        System.out.println(lookup.get(s) ? "Passed" : "Failed!!! " + s);
        s = "a**";
        System.out.println(lookup.get(s) ? "Passed" : "Failed!!! " + s);
        s = "***";
        System.out.println(lookup.get(s) ? "Passed" : "Failed!!! " + s);
        s = "**c";
        System.out.println(lookup.get(s) ? "Passed" : "Failed!!! " + s);
        s = "a**b";
        System.out.println(!lookup.get(s) ? "Passed" : "Failed!!! " + s);
        s = "****";
        System.out.println(!lookup.get(s) ? "Passed" : "Failed!!! " + s);
        s = "*";
        System.out.println(!lookup.get(s) ? "Passed" : "Failed!!! " + s);
        s = "*";
        System.out.println(!lookup.get(s) ? "Passed" : "Failed!!! " + s);
        s = "a*z";
        System.out.println(!lookup.get(s) ? "Passed" : "Failed!!! " + s);
        s = "**";
        System.out.println(!lookup.get(s) ? "Passed" : "Failed!!! " + s);
    }
}
