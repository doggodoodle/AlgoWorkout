package squarespace;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    final static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    final static TimeZone tz = TimeZone.getTimeZone("ISO-8601");

    final static int ARR_SIZE = 121;

    public static void main(String args[] ) throws Exception {
        Solution sol = new Solution();
        df.setTimeZone(tz);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        sol.startProcessing();
    }

    void startProcessing(){
        Scanner sc = new Scanner(System.in);
        long latest = -1;
        long arr2Min = -1;
        long arr1Min = -1;
        long i = 0;
        int[] arr1 = new int[ARR_SIZE];
        int[] arr2 = new int[ARR_SIZE];
        long cutOff = -1;

        while(sc.hasNextInt()){

            long t = sc.nextLong();
            double r = sc.nextDouble();


            System.out.println("START::Time:"+getIsoTime(t)+" t:"+t+ " r:"+r+ "cutOff:"+cutOff+" latest:"+latest+ " arr1Min:"+arr1Min+ "arr2Min:"+ arr2Min);

            if(t<latest){
                if(latest-t > 60) {
                    i++;
                    continue;
                }
                //out of order or old
                if(t<arr1Min)
                    addtoArray(arr1, r);
                else
                    addtoArray(arr2, r);
            }
            else{
                if(i==0){
                    cutOff = t+(59-t%60);
                    System.out.println("Adding to array2");
                    addtoArray(arr2, r);
                    arr2Min = cutOff;
                    latest = t;
                    i++;
                    continue;
                }
                if(t>=cutOff){
                    printOut(arr1, arr1Min);
                    arr1 = arr2;
                    System.out.println("Moving arr2 to array1");
                    arr1Min = arr2Min;
                    arr2 = new int[ARR_SIZE];
                    System.out.println("Adding to array2");
                    addtoArray(arr2, r);
                    latest = t;
                    cutOff = t+(59-t%60);
                    arr2Min = cutOff;
                }
                else {
                    System.out.println("Adding to array2");
                    addtoArray(arr2, r);
                    latest = t;

                }

            }


            i++;
            System.out.println("END::Time:"+getIsoTime(t)+" t:"+t+ " r:"+r+ "cutOff:"+cutOff+" latest:"+latest+ " arr1Min:"+arr1Min+ "arr2Min:"+ arr2Min);
            System.out.println();
        }
        System.out.println("here");
    }

    private void printOut(int[] arr, long arr1Min) {
        int count = 0;
        for(int i : arr){
            count+=i;
        }
        if(count==0) {
            System.out.println("Arr empty!");
            return;
        }
        System.out.println(getIsoTime(arr1Min)+" "+get90Percentile(arr, count));
    }

    static String getIsoTime(long seconds){
        Date d = new Date(seconds*1000);
        return df.format(d);
    }

    private void addtoArray(int[] arr1, double r) {
        if(r>120)
            return;
        int i = (int)r;
        arr1[i]++;
    }

    double get90Percentile(int[] array, long count){
        long tenPct = (long) (count*0.1);
        double num = 0;
        for(int i = array.length-1; i>0; i--){
            num += array[i];
            if(tenPct<num)
                return (i/2);
        }
        return 0;
    }

}
