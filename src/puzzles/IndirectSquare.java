package puzzles;

/**
 * Created by ritvikmathur on 11/12/16.
 */
public class IndirectSquare {
    public static int square(int n){

        if(n<0){
            String s ;
            s = Integer.toString(n);
            s = s.substring(1);
            n = Integer.parseInt(s);
        }




        int r = 0;

        for(int i = 0; i <n; i++){

            r = r + n;


        }

        return r;


    }

    public static void main(String[] args) {
        System.out.println(square(8));
    }
}
