package monicalist;

/**
 * Created  on 1/29/17.
 */
public class SinglyLinkedList{
    public int value;
    public SinglyLinkedList next;

    public SinglyLinkedList(int value) {
        this.value = value;
        this.next = null;
    }

    public void print(){

        System.out.print(value+":");
        if(next==null) {
            System.out.print("null");
            System.out.println();
            return;
        }
        next.print();
    }
}
