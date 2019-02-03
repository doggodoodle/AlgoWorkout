package puzzles;

/**
 * Created  on 4/3/16.
 */
public class StringReversal {

    public static void main(String[] args) {

        String reverse = reverseString2("abcdef");

        System.out.println(reverse);

    }

    private static String reverseString2(String word) {

        int i = word.length();

        StringBuffer sb = new StringBuffer(i);

        return new StringBuilder(word).reverse().toString();
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
