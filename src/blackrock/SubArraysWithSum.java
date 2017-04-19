package blackrock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ritvikmathur on 2/18/17.
 */
public class SubArraysWithSum {
    public static void main(String[] args) {
        int [] arr = {1,2,2};

        Arrays.sort(arr);

        /*for(int i = 0; i<arr.length/2; i++){
            int t = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = t;
        }*/

        System.out.println(Arrays.asList(arr));

        //System.out.println(Arrays.asList(arr));

        List<Integer> inList = new ArrayList<Integer>();
        for(int i: arr){
            inList.add(i);
        }

        System.out.println("Input :"+inList);

        List<List<Integer>> powerSet= getPowerSet(inList,0);//subsetsWithDup(arr);

        for(List<Integer> set : powerSet){
            System.out.println(set);
        }

    }

    private static void findSum(int[] arr,int n,int sum, ArrayList<Integer> list) {





    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        helper(res, each, 0, nums);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        if (pos <= n.length) {
            res.add(each);
        }
        int i = pos;
        while (i < n.length) {
            each.add(n[i]);
            helper(res, new ArrayList<>(each), i + 1, n);
            each.remove(each.size() - 1);
            i++;
            //while (i < n.length && n[i] == n[i - 1]) {i++;}
        }
        return;
    }

    private static List<List<Integer>> getPowerSet(List<Integer> list, int index){

        List<List<Integer>> powerSet;

        if(index == list.size()){
            powerSet= new ArrayList<List<Integer>>();
            powerSet.add(new ArrayList<Integer>());
        }
        else {
            //while (index < list.size()-1 && index>0 && list.get(index) == list.get(index-1)) {index++;}
            powerSet = getPowerSet(list, index+1);
            Integer item = list.get(index);
            List<List<Integer>> moreSets = new ArrayList<List<Integer>>();
            if(index<list.size()-1 && list.get(index) == list.get(index+1)){
                List<Integer> newSet = new ArrayList<Integer>();
                newSet.add(powerSet.size()-1);
                newSet.add(item);
                moreSets.add(newSet);
            }
            else{
                for(List<Integer> set : powerSet){
                    List<Integer> newSet = new ArrayList<Integer>();
                    newSet.addAll(set);
                    moreSets.add(newSet);

                }
            }
            powerSet.addAll(moreSets);
            for(List<Integer> set : powerSet){
                System.out.println(set);
            }
            System.out.println("-----");

        }

        return powerSet;
    }
}
