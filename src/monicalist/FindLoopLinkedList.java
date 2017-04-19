package monicalist;

/**
 * Created by ritvikmathur on 1/29/17.
 *
 * Given the root node to a singly linked list, write an algorithm to see if it loops back on itself somewhere in the middle.
 *
 */
public class FindLoopLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList root = new SinglyLinkedList(1);
        SinglyLinkedList tempList = root, loopBeg = null;
        for(int i = 2; i <=15; i++){
            tempList.next = new SinglyLinkedList(i);
            tempList = tempList.next;
            if(i==5)
                loopBeg = tempList;
        }

        tempList.next = loopBeg;

        System.out.println("Has loop:"+hasLoop(root));
    }

    static boolean hasLoop(SinglyLinkedList root){
        SinglyLinkedList p1 = root, p2 = root;
        while (p1!=null && p2!=null){

            p1 = p1.next;
            if(p2.next!=null)
                p2 = p2.next.next;
            else
                return false;
            if(p1==p2)
                return true;
        }

        return false;
    }

}
