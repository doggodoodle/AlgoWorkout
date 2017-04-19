package monicalist;

/**
 * Created by ritvikmathur on 1/29/17.
 *
 * Given a const null terminated string containing a sentence,
 * can you print out the words of the sentence in reverse without
 * changing any data and without creating a temporary string buffer?
 * Do not use any helper functions, write it all out on your own.
 *
 * You probably answer #5 using multiple passes.
 * One to find the length of the string, another to do the actual
 * reversal etc...  Can you solve the same problem with the same
 * restriction using only one pass?
 */
public class ReverseSentence {
    public static void main(String[] args) {
        final String s = "This is the sentence";

        System.out.println(s);

        for (int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)!=' ')
                System.out.print(s.charAt(i));
            else
                System.out.println();
        }
    }
}
