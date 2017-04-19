package linkedlist;

/**
 * Created by ritvikmathur on 1/2/17.
 */
public class ReverseList {
    static class ListNode {
        int value;
        ListNode next = null;
        public ListNode(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        printListAddress(n);
        printListAddress(deepCopy(n));
        printList(deepCopy(n));
    }

    static ListNode deepCopy(ListNode root){

        if(root==null)
            return null;

        ListNode node = new ListNode(root.value);

        ListNode node2 = node;

        while (root.next!=null){
            node.next = new ListNode(root.next.value);
            node = node.next;
            root = root.next;
        }

        return node2;
    }

    static ListNode reverseList(ListNode root){

        ListNode n = null;

        while (root!=null){
            ListNode next = root.next;
            root.next = n;
            n = root;
            root = next;

        }

        return n;
    }

    static void printListAddress(ListNode n){
        System.out.println("");
        while (n!=null){
            System.out.print(n+" -> ");
            n = n.next;
        }
        System.out.print("null");
    }

    static void printList(ListNode n){
        System.out.println("");
        while (n!=null){
            System.out.print(n.value+" -> ");
            n = n.next;
        }
        System.out.print("null");
    }
}
