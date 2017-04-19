package graph;

import java.util.HashSet;
import java.util.Set;

/**

 */
public class GraphTraversal {

    class Node {
        int data;
        boolean visited;
        Set<Node> set = new HashSet<>();
        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {



    }

}
