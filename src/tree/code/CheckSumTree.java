package tree.code;

public class CheckSumTree {
    static class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    static boolean isSum = true;

    public static void main(String[] args) {
        System.out.println();
    }

    boolean isSumTree(Node node)
    {
        if (node == null) {
            return isSum;
        }
        sum (node);
        return isSum;
    }

    static int sum(Node n) {
        if (!isSum) {
            return -1;
        }
        int lsum = 0, rsum = 0;
        if (n.left != null) {
            lsum = sum(n.left);
        }
        if (n.right != null) {
            rsum = sum(n.right);
        }
        if (n.left == null && n.right == null) {
            return n.data;
        }
        if (lsum + rsum != n.data) {
            isSum = false;
            return -1;
        } else {
            return 2*n.data;
        }
    }
}

