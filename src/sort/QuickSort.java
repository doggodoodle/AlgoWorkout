package sort;

import java.util.Arrays;

/**
 * Created by ritvikmathur on 1/3/17.
 */
public class QuickSort implements Sort{

    public static void main(String[] args) {
        int [] arr = {4,3,5,1,12,10};
        Sort quickSort = new QuickSort();
        System.out.println(quickSort.sort(arr));
    }

    static void quickSort(int[] arr , int left, int right){
        System.out.println(Arrays.toString(arr)+"quicksort : l="+left+"right="+right);
        if(left >= right)
            return;
        int pivot = arr[(left + right) / 2];
        int index = partition(arr, left, right, pivot);
        quickSort(arr,left, index-1);
        quickSort(arr,index, right);

    }

    static int partition(int[] arr, int left, int right, int pivot){
        System.out.println("partition: left:"+left+" right:"+right+" pivot:"+pivot);
        while (right >= left){
            while (arr[left]<pivot)
                left++;
            while (arr[right]>pivot)
                right--;

            if(left<=right){
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
                left++;
                right--;
            }

        }
        System.out.println(Arrays.toString(arr));
        return left;

    }

    @Override
    public int[] sort(int[] arr) {
        System.out.println("Running QuickSort");
        quickSort(arr, 0, arr.length-1);
        return arr;
    }
}
