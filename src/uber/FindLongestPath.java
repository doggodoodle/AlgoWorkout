package uber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindLongestPath {

    public static class Node {

        public Node(int val) {
            this.val = val;
        }
        public int val;
        public Node next = null;
    }

    public static void main(String args[] ) throws Exception {
        // Segment - 1->5->8->12->15->18
        // Segment - 20->25->29->32
        // Segment - 7->15
        // Segment - 3->1
        // Segment - 18->30
        // ...
        // Longest path:  1->5->8->12->15->18
        // Input: [[1,2,3],[4,5,6]]

        int[][] input = {{1,2,3},{4,5,6}};

        Map<Integer, Node> nodeMap = new HashMap<>();
        Set<Node> startingNodes = new HashSet<>();

        for (int [] arr : input) {
            Node prevNode = null;
            Node n;
            for (int i : arr) {
                if(nodeMap.containsKey(i)) {
                    n = nodeMap.get(i);
                }
                else {
                    n = new Node(i);
                    nodeMap.put(i, n);
                }
                if(i == 0) {
                    startingNodes.add(n);
                }
                else {
                    prevNode.next = n;
                }
                prevNode = n;
            }
        }
        int max = 0;
        Node longestStartNode = null;
        for(Node n : startingNodes) {
            int l = getLongestPathFromNode(n);
            if(l >= max) {
                longestStartNode = n;
            }
        }

        printPath(longestStartNode);
    }

    static void printPath(Node n) {
        while (n!=null) {
            System.out.print(n.val+"->");
        }
    }

    static int getLongestPathFromNode(Node n) {
        int l = 0;
        while(n!=null) {
            l++;
            n = n.next;
        }
        return l;
    }
}
