package java8;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by ritvikmathur on 3/17/17.
 */
public class Test {
    final static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
    final static TimeZone tz = TimeZone.getTimeZone("ISO-8601");



    public static void main(String[] args) {
        //System.out.println(System.currentTimeMillis()/1000);
        //2017-03-24T21:12:41Z = 1490404361
        df.setTimeZone(tz);
        long x  = 962668860;
        System.out.println(getIsoTime(x));
        System.out.println(getIsoTime(x));
        //System.out.println(x-x%60+"min-"+x%60);
        //System.out.println(x%60);

    }

    double get90Percentile(double[] array, long count){

        long tenPct = (long) (count*0.1);

        double num = 0;

        for(int i = array.length-1; i>0; i--){
            num += array[i];
            if(tenPct<num)
                return (i);
        }

        return 0;

    }

    static String getIsoTime(long seconds){
        Date d = new Date(seconds*1000);
        return df.format(d);
    }
}
