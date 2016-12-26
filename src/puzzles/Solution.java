package puzzles;

import java.util.*;
// int[][] map = {
//     { 1, 5, 0, 0, 0, 0, 0 },
//     { 0, 5, 0, 0, 0, 5, 0 },
//     { 0, 5, 0, 0, 0, 5, 0 },
//     { 0, 5, 0, 0, 0, 5, 0 },
//     { 0, 5, 0, 0, 0, 5, 0 },
//     { 0, 5, 0, 0, 0, 5, 0 },
//     { 0, 5, 0, 5, 5, 5, 0 },
//     { 0, 0, 0, 0, 0, 5, 9 },
// };

// output
/*
path
{
    // row, column
    { 0, 0 },
    { 1, 0 },
    ....
    { 7, 0 },
    { 7, 1 },
    { 7, 2 },
    { 6, 2 },
    ....
    { 7, 7 },
}
*/

public class Solution {

    public static void main(String args[]) {
        System.out.println("hello rivik we are friends");
        int[][] map = {
                { 1, 5, 0, 0, 0, 0, 0 },
                { 0, 5, 0, 0, 0, 5, 0 },
                { 0, 5, 0, 0, 0, 5, 0 },
                { 0, 5, 0, 0, 0, 5, 0 },
                { 0, 5, 0, 0, 0, 5, 0 },
                { 0, 5, 0, 0, 0, 5, 0 },
                { 0, 5, 0, 5, 5, 5, 0 },
                { 0, 0, 0, 0, 0, 5, 9 },
        };

        Solution sol = new Solution();

        GNode root= sol.createGraph(map);

        sol.traverseGraph( root , new ArrayList<GNode>());

    }

    public void printPath(List<GNode> visited){
        for(GNode n : visited){
            System.out.println("{"+n.x+","+n.y+"}");
        }
    }

    public void traverseGraph(GNode root, List<GNode> visited){

        if(root.data == 5 || root.visited) //wall / invalid
            return;

        List<GNode> newVisited = new ArrayList<GNode>(visited);

        newVisited.add(root);
        root.visited = true;

        if(root.data == 9){
            printPath(newVisited);
        } //END

        for(GNode n : root.connections){
            traverseGraph(n, newVisited);
        }

    }

    public GNode createGraph(int [][] array){



        HashMap<String, GNode> map = new HashMap<String, GNode>();


        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                map.put("n"+i+""+j , new GNode(i,j, array[i][j]));
                //map with n00 -> GNode(x=0,y=0, data) ...
            }
        }

        //now forming connections on the nodes based on the array structure

        map.get("n00").connections.add(map.get("n01"));
        map.get("n00").connections.add(map.get("n10"));

        map.get("n01").connections.add(map.get("n00"));
        map.get("n01").connections.add(map.get("n02"));
        map.get("n01").connections.add(map.get("n11"));

        map.get("n02").connections.add(map.get("n01"));
        map.get("n02").connections.add(map.get("n03"));
        map.get("n02").connections.add(map.get("n12"));

        map.get("n03").connections.add(map.get("n02"));
        map.get("n03").connections.add(map.get("n04"));
        map.get("n03").connections.add(map.get("n13"));

        map.get("n04").connections.add(map.get("n03"));
        map.get("n04").connections.add(map.get("n05"));
        map.get("n04").connections.add(map.get("n14"));

        map.get("n05").connections.add(map.get("n04"));
        map.get("n05").connections.add(map.get("n06"));
        map.get("n05").connections.add(map.get("n15"));

        map.get("n06").connections.add(map.get("n05"));
        map.get("n06").connections.add(map.get("n07"));
        map.get("n06").connections.add(map.get("n16"));

        map.get("n07").connections.add(map.get("n06"));
        map.get("n07").connections.add(map.get("n17"));



        //...

        return map.get("n00");
    }

    public class GNode{
        int x;
        int y;
        int data;
        List<GNode> connections;
        boolean visited = false;

        public GNode(int data, List<GNode> connections, int x, int y){
            this.data = data;
            this.connections = connections;
            this.x = x;
            this.y = y;
        }

        public GNode( int x, int y, int data){

            this.x = x;
            this.y = y;
            this.data = data;
        }

    }

}