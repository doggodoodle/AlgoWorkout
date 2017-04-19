package leetcode;

import java.util.concurrent.TimeUnit;

/**
 * Created by ritvikmathur on 3/11/17.
 *
 * [2, -1, 2, 1, 1, 1, -5, 6] | 3 --> 4
 *
 *
 *
 */
public class MaxSizeKSubArray {

    public static void main(String[] args) {
        long t1 = System.nanoTime();
        int[] arr = {1,-1,5,-2,3};
        System.out.println(getMaxSizeWithSumK(arr,3));
        long t2 = System.nanoTime();

        System.out.println(TimeUnit.NANOSECONDS.toMicros(t2-t1)+" mics");
    }

    public static int getMaxSizeWithSumK(int[] arr, int k){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int t = 0;
            for(int j = i; j< arr.length; j++){
                t += arr[j];
                if(t==k && j-i>=max) {
                    //System.out.println("i:"+i+" j:"+j);
                    max = j - i+1;
                }
            }
        }

        return max;
    }


}
