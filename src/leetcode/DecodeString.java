package leetcode;

/**
 * Created by ritvikmathur on 4/20/17.
 */
public class DecodeString {
    public static void main(String[] args) {
        long l = (long)999999999*(long)999999999*(long)999999999;
        System.out.println(l);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(l>Integer.MAX_VALUE);

    }

    public String decodeString(String s) {
        int closeIndex = s.indexOf("]");
        if(closeIndex<0)
            return s;
        return null;
    }
}
