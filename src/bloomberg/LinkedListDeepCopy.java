package bloomberg;

/**
 * Created by ritvikmathur on 11/19/16.
 *
 * Deep Copy a linked list along with random node pointers pointing to other nodes in the list.
 *
 * Limitation: Nodes contain unique data values.
 *
 */
public class LinkedListDeepCopy {
    static class Node{
        int data;
        Node next = null;
        Node random =null;
        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n1.random = n3;
        n2.random = n1;
        printList(n1);
        printList(deepCopy(n1));
    }

    static void printList(Node root){
        System.out.println("");
        while (root!=null){
            System.out.print(root.data+",node="+root.toString().substring(34)+",rand="+(root.random!=null?root.random.data+"|"+root.random.toString().substring(34):null)+" -> ");
            root = root.next;
        }
        System.out.print("/");
    }

    static Node deepCopy(Node root){
        Node oldroot = root;
        Node newNode = new Node(root.data);
        Node newRoot = newNode, newRoot2 = newNode;
        while (root.next!=null){
            newNode.next = new Node(root.next.data);
            root = root.next;
            newNode = newNode.next;
        }

        while (oldroot.next!=null) {
            if(oldroot.random!=null){
                int data = oldroot.random.data;
                Node node = newRoot2;
                while (node.data!=data && node!=null)
                    node = node.next;
                newRoot.random = node;
            }
            oldroot = oldroot.next;
            newRoot = newRoot.next;
        }
        return newRoot2;
    }


}
