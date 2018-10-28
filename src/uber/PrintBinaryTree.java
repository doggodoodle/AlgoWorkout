package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintBinaryTree {

    static Map<Character, Integer> map = new HashMap();

    static List<Character> list = new ArrayList<>();

    static int maxDepth = 0;

    public static void main(String[] args) {

        TreeNode a = new TreeNode('a');
        a.left = new TreeNode('b');
        a.right = new TreeNode('c');
        a.left.left = new TreeNode('d');
        a.left.right = new TreeNode('e');
        a.left.left.left = new TreeNode('f');
        a.left.left.right = new TreeNode('g');

        printTree(a);


    }

    public static void printTree(TreeNode head) {
        inOrder(head, 0);
        char[][] matrix = new char[map.size()][maxDepth + 1];
        int k = 0;
        for (Character c : list) {
            int depth = map.get(c);
            matrix[k][depth] = c;
            k++;
        }
        System.out.println(list);
        System.out.println(map);


        for (int i = 0; i < maxDepth + 1; i++) {
            for (int j = 0; j < map.size(); j++) {
                char c = matrix[j][i];
                if (c == (char) 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(c);
                }
            }
            System.out.println("");
        }


    }

    public static void inOrder (TreeNode head,int depth){
        maxDepth = Math.max(depth, maxDepth);
        if (head.left != null) {
            inOrder(head.left, depth + 1);
        }
        map.put(head.val, depth);
        list.add(head.val);
        if (head.right != null) {
            inOrder(head.right, depth + 1);
        }
    }
}
