package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created  on 12/17/16.
 *
 * https://www.hackerrank.com/challenges/bfsshortreach
 */
public class Djikstra {

    //Input: 4 4 1 2 1 2 3 3 3 4 3 4 2 7
    //n = 4
    //# of queries = 4
    //1>2 1
    //2>3 3
    //3>4 3
    //4>2 7

    public static void main(String[] args) {
        shortestPath(1);
    }

    static void shortestPath(int origin){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int queries = sc.nextInt();
        int matrix [][] = new int[n+1][n+1];
        int dist [] = new int[n+1];
        boolean visited [] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 1; i <=queries; i++){

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            matrix[a][b] = c;
            matrix[b][a] = c;
        }

        for(int i = 1; i <=n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[origin] = 0;
        visited[origin] = true;
        q.offer(origin);

        while(!q.isEmpty()){
            System.out.println(q);
            int current = q.poll();
            visited[current] = true;
            for (int i = 1; i<= n; i++){
                if(matrix[current][i] != 0){
                    if(dist[i] > dist[current]+matrix[current][i])
                        dist[i] = dist[current]+matrix[current][i];
                    if(visited[i]!=true){
                        q.offer(i);
                        visited[i] = true; // to avoid double adding to q
                    }
                }
            }
        }

        int x = 0;
        for (int i : dist){

            /*if(x==0){
                x=69;
                continue;
            }*/


            System.out.println(i);
        }

    }

}
