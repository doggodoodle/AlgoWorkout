package tree.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 4/18/17.
 */
public class PrintTreeLevels {

    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(6);
        root.left.left = new Node(-1);
        root.left.right = new Node(0);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        levels(root, 0);

        for(List<Integer> l : list){
            System.out.println(l);
        }
    }

    static List<ArrayList<Integer>> list = new ArrayList<>();

    private static void levels(Node root, int level) {
        if(list.size()<=level || list.get(level)==null)
            list.add(level, new ArrayList<Integer>());
        list.get(level).add(root.val);
        if(root.left!=null)
            levels(root.left, level+1);
        if(root.right!=null)
            levels(root.right, level+1);
    }
}
