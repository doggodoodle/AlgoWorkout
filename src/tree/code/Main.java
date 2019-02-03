package tree.code;

import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created  on 11/5/16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(preOrderTraverse(createTree()));
    }

    private static boolean preOrderTraverse(TreeNode<Integer> root) {
        if(root==null)
            return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            if(!checkBst(n))
                return false;
            if(n.getRight()!=null)
                stack.push(n.getRight());
            if(n.getLeft()!=null)
                stack.push(n.getLeft());
        }

        return true;
    }

    private static boolean checkBst(TreeNode<Integer> root){
        System.out.println("checking BST for root:"+root);
        if(root==null)
            return true;
        System.out.println("left sub:"+getLeftSubTree(root));
        System.out.println("right sub:"+getRightSubTree(root));
        for(TreeNode n : getLeftSubTree(root)){

            if((Integer)n.getData()>=root.getData())
                return false;
        }
        for(TreeNode n : getRightSubTree(root)){
            if((Integer)n.getData()<=root.getData())
                return false;
        }

        return true;

    }

    private static List<TreeNode> getLeftSubTree(TreeNode root){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(root==null || root.getLeft()==null)
            return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root.getLeft());

        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            list.add(n);
            if(n.getRight()!=null)
                stack.push(n.getRight());
            if(n.getLeft()!=null)
                stack.push(n.getLeft());
        }

        return list;
    }

    private static List<TreeNode> getRightSubTree(TreeNode root){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(root==null || root.getRight()==null)
            return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.peek();

        stack.push(root.getRight());

        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            list.add(n);
            if(n.getRight()!=null)
                stack.push(n.getRight());
            if(n.getLeft()!=null)
                stack.push(n.getLeft());
        }

        return list;
    }

    static TreeNode<Integer> createTree(){
        TreeNode<Integer> node = new TreeNode<Integer>(4);
        node.setLeft(new TreeNode(3));
        node.setRight(new TreeNode(9));
        node.getRight().setLeft(new TreeNode(16));
        node.getRight().setRight(new TreeNode(7));
        node.getLeft().setLeft(new TreeNode(1));
        //node.getLeft().setRight(new TreeNode(5));
        return node;
    }



}
