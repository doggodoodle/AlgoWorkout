package leetcode;

/**
 * Created  on 2/9/17.
 * https://leetcode.com/submissions/detail/92361572/
 *
 * https://leetcode.com/problems/paint-house/
 */
public class PaintHouse {

    public static void main(String[] args) {
        PaintHouse ph = new PaintHouse();
        System.out.println(ph.minCost(new int[][]{{18,17,7},{20,19,4},{5,8,15},{6,3,17},{7,6,6},{8,1,9},{1,11,19},{20,13,18},{15,17,3},{16,20,15},{16,7,15},{15,3,12},{19,5,10},{8,18,15},{2,16,17},{12,17,16},{10,8,16},{6,8,15},{14,3,18},{15,18,2},{20,10,20},{4,18,4},{7,8,2},{4,1,8},{8,13,20},{12,20,4}}));
    }

    int min = Integer.MAX_VALUE;
    int num = 0;
    public  int minCost(int[][] costs) {
        num = costs.length;
        if(num == 0)
            return 0;
        else if(num == 1){
            for(int c = 0; c<=2; c++){
                if(costs[0][c] < min)
                    min = costs[0][c];
            }
        }
        else{
            for(int c = 0; c<=2; c++){
                calculate(1,c, costs, costs[0][c]);
            }
        }
        return min;

    }

    void calculate(int i, int c, int[][] costs, int sum){

        for(int j = 0; j <=2; j++){

            if(j == c)
                continue;
            int s = sum+costs[i][j];
            if(i==num-1){
                if(s < min)
                    min = s;
                continue;
            }

            calculate(i+1,j, costs, s);
        }

    }
}
