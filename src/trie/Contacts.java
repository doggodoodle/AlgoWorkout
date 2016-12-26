package trie;

import java.util.Stack;

/**
 * Created by ritvikmathur on 12/19/16.
 */
public class Contacts {

    private static TrieNode root = new TrieNode('*');

    public static void main(String[] args) {
        Contacts contacts = new Contacts();
        contacts.add("ritvok");
        contacts.add("ritvik");
        contacts.add("ritvik");

        contacts.add("rit");
        contacts.add("alpha");
        System.out.println(contacts.findNode("ritv").count);
    }

    public static TrieNode findNode(String subStr){
        char[] chars = subStr.toCharArray();
        TrieNode node = root;
        for(char c : chars){
            TrieNode child = node.children.get(c);
            if(child == null)
                return null;
            node = child;

        }
        return node;
    }

    static void add(String name){
        if(findNode(name)!=null && findNode(name).isCompleteWord)
            return;
        char [] chars = name.toCharArray();
        int i = 0;
        TrieNode node = root;
        for(Character c : chars){

            if(node.children.containsKey(c)){
                node.children.get(c).count++;
                node = node.children.get(c);
            }
            else{

                node.children.put(c,new TrieNode(c));
                node = node.children.get(c);
                node.count++;
            }
            if(i == chars.length-1){
                node.isCompleteWord = true;
            }
            i++;
        }
    }

    int printAllWords(TrieNode node){
        if(node==null)
            return 0;
        int count = 0;
        Stack<TrieNode> stack = new Stack<TrieNode>();
        System.out.println(node.value);
        if(node.isCompleteWord){
            count++;
            System.out.print("--");
        }

        for(TrieNode n :node.children.values()){
            stack.push(n);
        }
        while (!stack.isEmpty()){
            TrieNode n = stack.pop();
            System.out.println(n.value);
            if(n.isCompleteWord){
                count++;
                System.out.print("--");
            }
            for (TrieNode nt : n.children.values()){
                stack.push(nt);
            }
        }
        return count;
    }
}
