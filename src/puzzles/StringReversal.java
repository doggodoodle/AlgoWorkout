package puzzles;

import java.math.BigInteger;

/**
 * Created by ritvikmathur on 4/3/16.
 */
public class StringReversal {

    public static void main(String[] args) {

        /*StringReversal stringReversal = new StringReversal();

        System.out.println(stringReversal.reverseString("Ri   tvik  "));*/

        System.out.println(new BigInteger("4"));


    }

    public String reverseString(String s){

        if(null!=s){

            int i = s.length();

            StringBuffer sb = new StringBuffer(i);

            for(; i>0; i--){

                sb.append(s.charAt(i-1));

            }

            s = sb.toString().replaceAll(" ","").toLowerCase();

        }

        return s;
    }
}
