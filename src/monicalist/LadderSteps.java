package monicalist;

import java.util.ArrayList;

/**
 * Created  on 1/28/17.
 *
 * You have a ladder n-steps in height.  You can either take one step or two steps up the ladder at a time.
 * How can you find out all the different combinations up the ladder?  Then figure out an algorithm that will
 * actually print out all the different ways up the ladder.  ie: 1,1,2,1,2,2... etc...
 */
public class LadderSteps {

    public static void main(String[] args) {
        countSteps(3, new ArrayList<Integer>());
        System.out.println(ways);
    }

    static ArrayList<ArrayList<Integer>> ways = new ArrayList<ArrayList<Integer>>();

    static void countSteps(int n, ArrayList<Integer> steps){

        if(n<=0)
            return;

        if(n==1){
            steps.add(1);
            ways.add(steps);
            return;
        }


        if(n==2){
            steps.add(2);
            ways.add(steps);
            ArrayList<Integer> ones = new ArrayList<Integer>(steps);
            ones.remove(steps.size()-1);
            ones.add(1);
            ones.add(1);
            ways.add(ones);
            return;
        }

        ArrayList<Integer> onePlus = new ArrayList<Integer>(steps);
        onePlus.add(1);

        ArrayList<Integer> twoPlus = new ArrayList<Integer>(steps);
        twoPlus.add(2);

        countSteps(n-1, onePlus);
        countSteps(n-2, twoPlus);


    }
}
