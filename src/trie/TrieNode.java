package trie;

import java.util.HashMap;

/**
 * Created by ritvikmathur on 12/19/16.
 */
public class TrieNode {

    public Character value;

    public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public boolean isCompleteWord = false;

    public int count = 0;

    public TrieNode(Character value) {
        this.value = value;
    }

    public TrieNode() {

    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "value=" + value +
                ", children=" + children +
                ", isCompleteWord=" + isCompleteWord +
                ", count=" + count +
                '}';
    }
}
