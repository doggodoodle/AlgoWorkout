package tree.code;

import apple.laf.JRSUIUtils;

import java.util.*;

public class BinaryTreeSerialieDeserialize {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i+"");
        }
        System.out.println(String.join("|", list));*/
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);

        BinaryTreeSerialieDeserialize app = new BinaryTreeSerialieDeserialize();
        String t = app.serialize(root);
        System.out.println(t);

        System.out.println(app.serialize(app.deserialize(app.serialize(root))));

        //System.out.println(app.deserialize("5 2 3 null null 2 4 3 1"));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n == null) {
                sb.append("null ");
            } else {
                sb.append(n.val + " ");
                queue.offer(n.left);
                queue.offer(n.right);
            }
        }
        return sb.toString();
    }

    /*

    static void serialize(Map<Integer, List<TreeNode>> lMap, Map<Integer, Boolean> bMap, int l, Queue<TreeNode> queue) {

        TreeNode n = queue.poll();
        lMap.computeIfAbsent(l, v -> new ArrayList<>()).add(n);
        bMap.put(l, n != null);
        if (!bMap.get(l) && lMap.get(l).size() >= Math.pow(2, l)) {
            return;
        }
        queue.add(n!=null ? n.left : null);
        queue.add(n!=null ? n.right : null);
        serialize(lMap, bMap, l+1, queue);
    }*/



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        data = data.trim();
        String[] strings = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode n = decode(strings[0]);
        queue.offer(n);
        int i = 1;
        while (i < strings.length) {
            for (int j = 0; j < queue.size(); j++) {
                TreeNode node = queue.poll();
                node.left = decode(strings[i++]);
                node.right = decode(strings[i++]);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return n;
    }

    static TreeNode decode(String s) {
        return s.equals("null") ? null : new TreeNode(Integer.valueOf(s));
    }
}
