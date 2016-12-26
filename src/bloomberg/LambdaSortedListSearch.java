package bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ritvikmathur on 11/20/16.
 *
 * Binary search in a lambda sorted list
 *
 * List: 1 2 3 6 7 15 13 12 9 2
 *
 */
public class LambdaSortedListSearch {

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,6,7,8,   9,10,10,10,11,5,4,  3,0};

        int peakIndex = getPeakIndex(arr);
        System.out.println("peak index = "+peakIndex);

        Integer[] ascArr = Arrays.copyOfRange(arr, 0 , peakIndex);
        Integer[] desArr = Arrays.copyOfRange(arr, peakIndex, (arr.length-1));

        Collections.reverse(Arrays.asList(desArr));

        System.out.println("arr1="+new ArrayList<Integer>(Arrays.asList(ascArr)));
        System.out.println("arr2="+new ArrayList<Integer>(Arrays.asList(desArr)));
    }

    static Integer getPeakIndex(Integer[] arr){

        int beg=0, end = arr.length-1, mid;
        Integer peakElement = null;
        Integer peakIndex = null;
        while(peakElement==null && beg<end){
            mid = (beg+end)/2;
            System.out.println("mid = "+mid);
            String side = isPeak(arr, mid);
            System.out.println("checking index:"+mid+" element:"+arr[mid]+ " result="+side);
            if(side.equals("YES")){
                peakElement = arr[mid];
                peakIndex = mid;
            }
            else if(side.equals("LEFT")){
                beg = mid;
            }
            else
                end = mid;
        }
        return peakIndex;
    }

    static String isPeak(Integer [] arr, int i){
        if(i==0)
            return "LEFT";
        if( i+1==arr.length )
            return "RIGHT";
        if(arr[i]>=arr[i-1] && arr[i]>arr[i+1]){
            return "YES";
        }
        if(arr[i]<arr[i-1])
            return "RIGHT";
        else
            return "LEFT";
    }
}
