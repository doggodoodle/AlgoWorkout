package monicalist;

/**
 * Created by ritvikmathur on 1/28/17.
 *
 * Given the root node to a singly linked list,
 * reverse the last 5 nodes in the list.
 */
public class LinkedListPartialReverse {



    public static void main(String[] args) {
        SinglyLinkedList root = new SinglyLinkedList(1);
        SinglyLinkedList tempList = root;
        for(int i = 2; i <=15; i++){
            tempList.next = new SinglyLinkedList(i);
            tempList = tempList.next;
        }
        root.print();

        try {
            reverseLastN(root, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        root.print();

    }



    static SinglyLinkedList reverseLastN(SinglyLinkedList root, int n) throws Exception {

        SinglyLinkedList endPtr = root, trailPtr = root;

        int i = 0;

        while(endPtr.next!=null){
            System.out.println("i="+i+" ptr:"+endPtr.value);
            endPtr = endPtr.next;
            if(i>n-1)
                trailPtr = trailPtr.next;
            i++;
        }

        System.out.println("endPtr:"+endPtr.value);

        System.out.println(trailPtr.value+" "+endPtr.value);

        trailPtr.next = reverseList(trailPtr.next);

        return root;
    }

    static SinglyLinkedList reverseList(SinglyLinkedList root){
        SinglyLinkedList n = null;

        SinglyLinkedList t =  null;

        while (root!=null){
            
            SinglyLinkedList next = root.next;

            root.next = n;

            n = root;

            t = root;

            root = next;

        }
        return t;

    }
}
