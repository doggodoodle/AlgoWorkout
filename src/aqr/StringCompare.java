package aqr;

import java.util.HashSet;

/**
 * Created  on 12/11/16.
 *
 * ERIC = RICE <> REIC
 *
 */
public class StringCompare {

    public static void main(String[] args) {
        System.out.println(compare("ERIC", "RICE"));

    }

    static boolean compare(String s1, String s2){
        if(s2.length() < s1.length()){
            String temp = ""+s1;
            s2 = ""+s1;
            s1= temp;
        }

        HashSet<String> set1 = new HashSet<String>();

        for(int i = 0; i < s1.length(); i++){
            StringBuilder stringBuilder = new StringBuilder();
            for(int k = i; k < s1.length(); k++){
                System.out.println(k);
                stringBuilder.append(s1.charAt(k));
            }
            for(int k = 0; k <i; k++){
                stringBuilder.append(s1.charAt(k));
            }
            set1.add(stringBuilder.toString());

        }

        return set1.contains(s2);


    }
}
