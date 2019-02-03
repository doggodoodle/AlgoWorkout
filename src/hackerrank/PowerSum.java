package hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created  on 5/17/17.
 * https://www.hackerrank.com/challenges/the-power-sum
 */
public class PowerSum {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            int n = scan.nextInt();
            scan.close();
            System.out.println(pof(x, n));
        }

        static int pof(int x, int n){
            List<Integer> list = new ArrayList<>();
            for(int i = 1; Math.pow(i, n) <= x; i++){
                list.add(i);
            }
            int[] res = new int[1];
            res[0] = 0;
            //System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                traverse(list, i,n,x, new HashSet<Integer>(), res, 0);
            }



            return res[0];
        }

    private static void traverse(List<Integer> list, int i,int n, int x, HashSet<Integer> visited, int[] res, int sum) {
        //System.out.println("e:"+list.get(i)+ " visited:"+visited+ " sum:"+sum);
            if(visited.contains(list.get(i)))
                return;
            sum += Math.pow(list.get(i), n);
            if(sum == x) {
                //System.out.println("*** found");
                res[0]++;
                return;
            }
            if(sum>x) {
                //System.out.println("returned");
                return;

            }

            visited.add(list.get(i));


            for (int j = i+1; j < list.size(); j++) {
                traverse(list, j, n, x, new HashSet<>(visited), res, sum);
            }
    }

    static int pof(int x, int n, int i) {
            System.out.println("x:"+x+" n:"+n+" i:"+i);
            x = x - (int) Math.pow(i, n);
            if (x == 0) return 1;
            if (x > 0) {
                int sum = 0;
                System.out.println("sum:"+sum);
                for (int j = i + 1; Math.pow(j, n) <= x; j++) {
                    sum += pof(x, n, j);
                    System.out.println("sum:"+sum);
                }
                return sum;
            }
            else return 0;
        }

}
