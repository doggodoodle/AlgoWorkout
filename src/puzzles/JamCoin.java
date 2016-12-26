package puzzles;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ritvikmathur on 4/9/16.
 */
public class JamCoin {

    public static void main(String[] args) throws Exception{

        //System.out.println(checkPrimeWithBase( "101", 2));

        Scanner sc = new Scanner(new File("resc/C-large.in"));

        int t = sc.nextInt();
        int n = sc.nextInt();
        int j = sc.nextInt();

        System.out.println("Case #1:");
        printNumber(n, j);

        //System.out.println(Integer.toString(3,2));

        //System.out.println(getFormattedBinary(Integer.toString(3, 2), 5));
    }

    public static String getFormattedBinary(String i, int length){

        int l = i.length();

        if(l == length)
            return i;

        int z = length - l;

        StringBuffer sb = new StringBuffer(length);

        while(z!=0) {
            sb.append("0");
            z--;
        }

        sb.append(i);

        return sb.toString();


    }



    private static void printNumber(int length, int count){
        int i = 0;

        while(count > 0){
            i++;
            String num = "1"+getFormattedBinary(Integer.toString(i, 2),length-2)+"1";

            if(valid(num)) {
                System.out.println("");
                count--;
            }
        }
    }

    private static boolean valid(String ret) {

        List<BigInteger> list = new ArrayList<BigInteger>(9);

        for(int i = 2; i <=10; i++){
            BigInteger divisor = checkPrimeWithBase(ret, i);
            if( divisor.intValue() == -1)
                return false;
            else
                list.add(divisor);

        }
        System.out.print(ret + " ");
        for (BigInteger i : list){
            System.out.print(i + " ");
        }

        return true;
    }

    public static BigInteger checkPrimeWithBase( String n, int base){
        //System.out.println("base="+base);
        BigInteger num = new BigInteger(n, base);
        //System.out.println("Num = "+num);
        return getDivisor(num);
    }

    public static BigInteger getDivisor(BigInteger n){

        final BigInteger TWO =  new BigInteger("2");

      if (n.remainder(TWO).equals(BigInteger.ZERO)) return TWO;
        //if not, then just check the odds
        for(long i=3;i*i<=n.doubleValue();i+=2) {
            BigInteger I = new BigInteger(Long.toString(i));
            if(n.remainder(I).equals(BigInteger.ZERO))
                return I;
        }

        return BigInteger.ONE.negate();
    }
}
