package monicalist;

/**
 * Created by ritvikmathur on 1/29/17.
 */
public class Sqrt {

    public static void main(String[] args) {
        //double d = Math.sqrt(3); 1.7320508075688772
        int i = 7*7*7*7;
        System.out.println(sqrt(i));
        System.out.println(Math.sqrt(i));
    }

    public static double sqrt(int number) {
        double t;

        double squareRoot = number / 2;

        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
            System.out.println("t="+t+" squareroot="+squareRoot);
        } while (t!=squareRoot);

        return squareRoot;
    }

}
