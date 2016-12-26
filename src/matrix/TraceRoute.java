package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ritvikmathur on 7/20/16.
 *
 * Trace all routes of worm from (0,0) of matrix to (n,n)
 *
 */
public class TraceRoute {

    private class Node{

        public int val = 0;
        public boolean visited = false;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", visited=" + visited +
                    '}';
        }
    }

    final static int i = 4;
    final static int j = 3;

    public static void main(String[] args) {


        Node m [][] = new Node[i][j];

        TraceRoute tr = new TraceRoute();

        tr.init(m);

        m[0][0].val = 1;
        m[i-1][j-1].val = 1;

        List<String> l = new ArrayList<String>();

        for(int a = 0; a<i; a++){
            for(int b = 0; b<j; b++){

            }
        }



        System.out.println(m[0][0]);
    }

    private void init(Node[][] m) {
        for(int p = 0; p<i; p ++){
            for(int q = 0; q<j; q++){
                m[p][q] = new Node();
            }
        }

    }

}
