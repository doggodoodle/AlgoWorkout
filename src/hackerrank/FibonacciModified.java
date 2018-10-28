package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by ritvikmathur on 11/23/16.
 */
public class FibonacciModified {

    static BigInteger t1= BigInteger.valueOf(0), t2= BigInteger.valueOf(0);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named FindLongestPath. */
        Scanner sc = new Scanner(System.in);
        t1 = BigInteger.valueOf(sc.nextInt());
        t2 = BigInteger.valueOf(sc.nextInt());
        int n = sc.nextInt();
        System.out.println(fib(n));
    }

    static BigInteger fib(int n){
        if(n==1)
            return t1;
        if(n==2)
            return t2;

        return fib(n-2).add(fib(n-1).multiply(fib(n-1)));
    }

}
