package addepar;

import java.util.Arrays;

/**
 * Created  on 2/21/17.
 */
public class RotatedOrderedArraySearch {

    public static void main(String[] args) {
        find(new int[]{6,7,1,2,3,4}, 3);
        System.out.println(binarySearch(new int[]{1,2,3,4}, 10));
    }

    static boolean isPivot(int[] a, int i){

       /* int n = a.length-1;

        if(i==n){
            if()
        }


        return 0;*/
       return false;
    }

    static boolean binarySearch(int[] a, int n){

        int l = 0;
        int h = a.length;

        while (l<h){
            int mid = (l+h)/2;
            if(a[mid]==n)
                return true;
            else if(a[mid]<n)
                l = mid+1;
            else
                h = mid-1;
        }

        return  false;
    }


    static boolean find(int[]a, int n){
        int l = 0;
        int h = a.length-1;
        int pivot = -1;
        if(n>=a[0]){
            //front search
            while (l<h){
                int mid = (l+h)/2;
                if(a[mid] > l && isPivot(a, mid)){
                    pivot = mid;
                    break;
                }
                else if(a[mid] > l){
                    if(a[mid]>n){
                        l = mid+1;
                    }
                    else if (a[mid]<n)
                        h = mid-1;
                    else
                        return true;

                }
                else if(a[mid] < l){
                    h = mid-1;
                }
            }
            if(pivot!=-1){
                return binarySearch(Arrays.copyOf(a,pivot),n);
            }


        }
        else if(n<=a[a.length-1]){
            //back search
        }
        else
            return false;


        return false;
    }
}
