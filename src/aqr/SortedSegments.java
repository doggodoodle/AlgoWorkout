package aqr;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 */
public class SortedSegments {
    public static void main(String[] args) {
        System.out.println(segments("123AA12A"));
    }

    static int typeOf(char c){
        System.out.println("typeOf: "+c);
        if( 'A' <= c && c <= 'Z')
            return 1;
        else if ('0' <= c && c <= '9')
            return 2;
        else
            return 0;
    }

    static List<String> parse(String s){
        List<String> segs = new ArrayList<>();
        int b = 0, e = 0, currentType;
        while(e < s.length()){
            currentType = typeOf(s.charAt(e));

                do{
                    System.out.println("do:");
                    e++;
                }
                while (e < s.length() && currentType == typeOf(s.charAt(e)));
                System.out.println("b:"+b+" e:"+e);
                System.out.println("segs:"+segs);
                segs.add(s.substring(b,e));


            b = e;
        }
        return segs;


    }

    static BigInteger t1= BigInteger.valueOf(0), t2= BigInteger.valueOf(0);

    static List<String> segments(String s){
        ConcurrentHashMap map = new ConcurrentHashMap();
        List<String> segments = new ArrayList<String>();
        int b = 0, e = 0;
        boolean type = isNum(s.charAt(b));
        while(e<s.length()){
            e++;
            System.out.println("e="+e);
            boolean nextType = !type;
            if(e<s.length())
                nextType = isNum(s.charAt(e));
            if(nextType != type){
                segments.add(s.substring(b,e));
                System.out.println(segments);
                b=e;
                if(b<s.length())
                    type = isNum(s.charAt(b));
            }
        }


        return segments;
    }

    static boolean isNum(char c){

        System.out.println("type calc"+c);

        if(c >= '0' && c <= '9')
            return true;

        return false;
    }
}
