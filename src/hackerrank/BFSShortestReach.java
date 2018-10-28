package hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ritvikmathur on 12/18/16.
 */
public class BFSShortestReach {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named FindLongestPath. */

        Scanner sc = new Scanner(System.in);

        int qr = sc.nextInt();

        for(int i = 0; i<qr; i++){
            //System.out.println("Running case#"+i);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][] matrix = new int [n+1][n+1];
            int [] dist = new int[n+1];
            boolean [] visited = new boolean[n+1];
            Queue<Integer> q = new LinkedList();

            for(int j =0; j <n+1; j++){
                dist[j] = Integer.MAX_VALUE;
            }

            //System.out.println("dist init---"+Arrays.toString(dist));

            for(int k = 1; k <= m; k++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                matrix[a][b] = 6;
                matrix[b][a] = 6;

            }
            //System.out.println(Arrays.toString(matrix[1]));

            int s = sc.nextInt();
            dist[s] = 0;
            q.offer(s);
            visited[s] = true;

            while(!q.isEmpty()){
                //System.out.println("qu:"+q);
                int curr = q.poll();
                //System.out.println("curr="+curr);
                for(int l = 1; l <= n; l++){
                    //System.out.println("l="+l);
                    //System.out.println("matrix[curr][l]="+matrix[curr][l]);
                    if(matrix[curr][l]!=0){

                        if(dist[l]>(dist[curr]+matrix[curr][l])) {
                            //System.out.println("dist of l being updated="+dist[curr]+matrix[curr][l]);
                            dist[l] = dist[curr] + matrix[curr][l];
                        }
                        //System.out.println("dist[l]="+dist[l]);
                        //System.out.println("visited[curr]="+visited[curr]);
                        if(visited[l]!=true){
                            //System.out.println("inserting:"+curr);
                            q.offer(l);
                            visited[l] = true;
                        }
                    }
                }
            }

            //System.out.println(Arrays.toString(dist));
            for(int g = 1; g <= n; g++){
                if(g == s )
                    continue;
                if(dist[g]==Integer.MAX_VALUE)
                    System.out.print("-1 ");
                else
                    System.out.print(dist[g]+" ");
            }
            System.out.println("");

        }

    }
}
