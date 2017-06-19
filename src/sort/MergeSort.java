package sort;

import java.util.Arrays;

/**
 * Created by ritvikmathur on 6/18/17.
 */
public class MergeSort implements Sort {
    public static void main(String[] args) {
        Sort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sort(new int[]{2, 5, 10, 20, 1, 1,1})));

    }
    @Override
    public int[] sort(int[] arr) {
        return mergeSort(arr);
    }

    int[] mergeSort(int[] arr){
        if(arr.length <=1)
            return arr;
        if(arr.length==2){
            if(arr[0]>arr[1]){
                int t = arr[0];
                arr[0] = arr[1];
                arr[1] = t;
                return arr;
            }
        }
        int mid = arr.length/2;
        int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] arr2 = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(arr1, arr2);
    }

    int[] merge(int [] arr1, int [] arr2){
        System.out.println("merging "+Arrays.toString(arr1)+" and "+Arrays.toString(arr2));
        int i = 0;
        int j = 0;
        int [] res = new int[arr1.length+ arr2.length];
        int r = 0;
        while(i<=arr1.length-1 && j<=arr2.length-1){
            if(arr1[i]<=arr2[j]){
                res[r++] = arr1[i++];
            }
            else if(arr2[j]<=arr1[i]){
                res[r++] = arr2[j++];
            }
        }
        if(i<=arr1.length-1){
            for(; i<arr1.length; i++){
                res[r++] = arr1[i];
            }
        }
        else if(j<=arr2.length-1){
            for(; j<arr2.length; j++){
                res[r++] = arr2[j];
            }
        }
        return res;
    }
}
