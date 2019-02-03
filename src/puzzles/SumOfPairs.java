package puzzles;

import java.util.*;

/**
 * Created  on 1/2/17.
 *
 * Find pairs in array with sum n
 */
public class SumOfPairs {
    public static void main(String[] args) {
        int [] arr = {1,4,5,2,3,2,3,2};

        //findPairsWithSum(arr, 5);
        findPairsWithSumInPlace(arr,5);
    }

    static void findPairsWithSumInPlace(int[] arr, int n){
        //O(n*log(n))
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int p = 0;
        int q = arr.length-1;

        while(q > p){
            int v = arr[p]+arr[q];

            if(v==n){
                System.out.println(arr[p]+" - "+arr[q]);
                p++;
                q--;
                continue;
            }
            if(v<n){
                p++;
                continue;
            }
            else{
                q--;
                continue;
            }
        }

    }

    private static void findPairsWithSum(int[] arr, int n) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i : arr){
            if(map.get(i)!=null){
                int v = map.get(i);
                v++;
                map.put(i, v);
            }
            else {
                map.put(i, 1);
            }
        }


        for(int i = 0; i < arr.length; i++){



            int a = arr[i];

            int b = n - a;

            System.out.println("checking a= "+a+" b="+b+" map = "+map);

            if(map.get(b) != null && map.get(a) != null){
                System.out.println(a + " - " + b);
                if(map.get(a) > 1){
                    int v = map.get(a);
                    v--;
                    map.put(a, v);
                }
                else{
                    map.remove(a);
                }
                if(map.get(b) > 1){
                    int v = map.get(b);
                    v--;
                    map.put(b, v);
                }
                else{
                    map.remove(b);
                }
            }

        }

    }
}
