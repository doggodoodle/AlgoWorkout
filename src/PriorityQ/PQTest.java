package PriorityQ;

import java.util.PriorityQueue;

/**
 * Created  on 5/10/17.
 */
public class PQTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(34);
        priorityQueue.add(2);
        priorityQueue.add(2);
        priorityQueue.add(96);
        priorityQueue.remove(2);
        //priorityQueue.peek();
        System.out.println(priorityQueue);
    }
}
