package hackerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ritvikmathur on 1/16/17.
 */
public class SubstringPalindrome {

    static Set<String> getSubstrings(String str){
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length() - i; j++) {
                String elem = str.substring(j, j + (i+1));
                if (!set.contains(elem)) {
                    set.add(elem);
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aaaaa"));
    }

    static boolean isPalindrome(String s){
        for(int i = 0, j = s.length()-1 ; i < s.length()/2; i++, j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
