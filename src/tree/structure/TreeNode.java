package tree.structure;

/**
 * Created  on 11/21/15.
 */
public class TreeNode <T> {
    private T data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(T data) {

        this.data = data;
    }

    @Override
    public String toString() {

        if(this == null)
            return null;
        else
            return data.toString();

       /* return "TreeNode{" +
                "data=" + data +
                ", left=" + left.getData() +
                ", right=" + right.getData() +
                '}';*/
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
