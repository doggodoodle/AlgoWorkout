package hackerrank;

import java.util.Scanner;

/**
 * Created by ritvikmathur on 12/18/16.
 */
public class MaxSubArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named FindLongestPath. */

        Scanner sc = new Scanner(System.in);
        int tNum = sc.nextInt();
        //System.out.println("tNum:"+tNum);

        for(int t = 0; t < tNum; t++){

            int n = sc.nextInt();
            System.out.println("n:"+n);
            int a [] = new int[n];

            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }

            System.out.println(contagiousMaxSum(a)+" "+nonContagiousMax(a));

        }
    }

    static int nonContagiousMax(int [] a){
        int max = 0;
        boolean found = false;

        for(int i=0; i<a.length; i++){
            if(a[i]>0){
                max = max+a[i];
                found = true;
            }
        }

        if(!found){
            max = a[0];

            if(a.length>1){
                for(int i=1; i<a.length; i++){
                    if(a[i]>max){
                        max = a[i];
                    }
                }
            }

        }

        return max;
    }

    static int contagiousMaxSum(int [] a){

        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < a.length; i ++){

            for(int j = a.length-1; j>=i; j--){

                //System.out.println("i="+i+" j="+j);
                Integer sum = a[i];
                for(int k = i+1; k <=j; k++){
                    //System.out.println("a[k]="+a[k]);
                    sum = sum + a[k];
                    //System.out.println("sum="+sum);
                }
                if(sum>max)
                    max = sum;

            }

        }

        return max;
    }



}
