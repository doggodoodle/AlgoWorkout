package tree.code;

import tree.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ritvikmathur on 11/21/15.
 */
public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createTree(new TreeNode());
        //System.out.println("Height="+bt.getDepth(root));
        //bt.preOrderRecurssive(root);
        int[] list= {1,2,3,4,5,6,7,8};
        root = bt.getTree(list);
        bt.levelOrderTraverse(root);


    }

    TreeNode getTree(int [] list){ //Level order list

        if(list==null || list.length == 0)
            return null;

        TreeNode root = new TreeNode(list[0]);

        int i = 1;
        while(i<list.length-1){
            System.out.println("Inserting "+list[i]);
            TreeNode n = new TreeNode(list[i]);

            boolean inserted = false;
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            while (!inserted && !queue.isEmpty()){
                TreeNode n1 = queue.poll();
                if(n1.getLeft()==null){
                    n1.setLeft(n);
                    inserted = true;
                    continue;
                }
                else
                    queue.offer(n1.getLeft());
                if(n1.getRight()==null){
                    n1.setRight(n);
                    inserted = true;
                    continue;
                }
                else
                    queue.offer(n1.getRight());

            }
           i++;
        }
        return  root;
    }

    void levelOrderTraverse(TreeNode root){
        /**
         *              1
         *        2          3
         *      4   5      6   7
         *    8
         *
         *
         */
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

        queue.offer(root);

        levelOrderRecur(queue);
    }

    Queue<TreeNode> levelOrderRecur(Queue<TreeNode> queue){

        if(queue.isEmpty())
            return null;

        TreeNode n = queue.poll();

        System.out.println(n);

        if(n.getLeft()!=null)
            queue.offer(n.getLeft());

        if(n.getRight()!=null)
            queue.offer(n.getRight());

        return levelOrderRecur(queue);

    }

    private int getDepth(TreeNode root){

        if(root == null)
            return -1;

        return 1+Math.max(getDepth(root.getLeft()),getDepth(root.getRight()));
    }

    public void bfsTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(root ==null || root.getData() == null)
            return;

        queue.add(root);

        while(queue.size()>0){

            TreeNode n = queue.remove();

            System.out.println(n.getData());

            if(n.getLeft()!=null)
                queue.add(n.getLeft());

            if(n.getRight()!=null)
                queue.add(n.getRight());

        }
    }

    public void inOrderRecurssive(TreeNode n){

        if(n == null)
            return;

        if(n.getLeft() != null)
            inOrderRecurssive(n.getLeft());

        System.out.println(n.getData());

        if(n.getRight() != null)
            inOrderRecurssive(n.getRight());

    }

    public void preOrderRecurssive(TreeNode n){

        if(n == null)
            return;

        System.out.println(n.getData());

        if(n.getLeft() != null)
            preOrderRecurssive(n.getLeft());

        if(n.getRight() != null)
            preOrderRecurssive(n.getRight());

    }

    public void iddfs(TreeNode n){
        int depth = getDepth(n);
    }

    public void iddfs(TreeNode n, int d){
        if(n == null || d==0)
            return;

        System.out.println(n.getData());

        if(n.getLeft() != null)
            iddfs(n.getLeft(), d-1);

        if(n.getRight() != null)
            iddfs(n.getRight(), d-1);
    }


    public int getHeight(TreeNode root) {

        if((root==null))
            return 0;

        return 1 + Math.max(getHeight(root.getLeft()),getHeight(root.getRight()));
    }

    public TreeNode createTree(TreeNode n1) {
        /**
         *              1
         *        2          3
         *      4   5      6   7
         *    8
         *
         *
         */
        n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        n4.setLeft(n8);

        return n1;

    }

    public TreeNode createTreeForGraph(TreeNode n1) {
        /**
         *            1
         *         2    3
         *       4   5 8  6
         *     9  7
         *
         *
         */
        n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n8);
        n3.setRight(n6);
        n4.setLeft(n9);
        n4.setRight(n7);

        return n1;

    }
}
