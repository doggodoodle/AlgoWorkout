package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created  on 3/11/17.
 *
 * abcdefg
 *
 * a
 * ab
 * abc
 * abcd
 *
 * b
 * bc
 * bcd
 *
 * c
 * cd
 *
 * d
 *
 *
 *
 * abc
 *
 * a
 * b
 * c
 * ab
 * bc
 * abc
 *
 */
public class AllSubArrays {

    public static void main(String[] args) {
        int[] arr = {12,13,15,20};
        for(int[] a : getAllSubs(arr)){
            System.out.println(Arrays.toString(a));
        }
    }

    public static List<int[]> getAllSubs(int[] arr){
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j< arr.length; j++){
                list.add(Arrays.copyOfRange(arr,i,j));
            }
        }

        return list;
    }

    static List<String> getAllSubstrings(String s){

        List<String> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j< s.length(); j++){
                list.add(s.substring(i,j+1));
            }
        }


        return list;
    }

}
