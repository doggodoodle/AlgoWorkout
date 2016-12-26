package matrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ritvikmathur on 12/22/16.
 */
public class Test {
    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(a);
    }

    public static void rotate(int[][] matrix) {

        if(matrix.length ==1 && matrix[0].length == 1)
            return;


        int[][] res = new int[matrix.length][matrix.length];

        /*
        1  2  3
        4  5  6
        7  8  9


         7 4 1
         8 5 2
         9 6 3


        */

        Queue<Integer> q = new LinkedList<Integer>();
        for(int j = 0; j < matrix.length; j++){
            for(int i = matrix.length-1; i >= 0; i--){
                q.add(matrix[i][j]);
                //System.out.println("Adding "+matrix[i][j]);
            }
        }

        //System.out.println("q="+q);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                res[i][j] = q.poll();
            }
        }
        //System.out.println("");
        matrix = res;
       /* for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }*/

    }

}
