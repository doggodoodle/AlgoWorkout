package blackrock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ritvikmathur on 2/18/17.
 */
public class SubArraysWithSum {
    public static void main(String[] args) {
        int [] arr = {2, 3};

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

    private static List<List<Integer>> getPowerSet(List<Integer> list, int index) {
        List<List<Integer>> powerset;
        if (index == list.size()) {
            powerset = new ArrayList<>();
            powerset.add(new ArrayList<Integer>());
        } else {
            powerset = getPowerSet(list, index + 1);
            System.out.println("index:"+index);
            System.out.println("powerset:"+powerset);
            Integer item = list.get(index);
            System.out.println("item:"+item);
            List<List<Integer>> moresets = new ArrayList<>();
            System.out.println("moresets:"+moresets);
            for (List<Integer> set : powerset) {
                System.out.println("set:"+set);
                List<Integer> moreSet = new ArrayList<>();
                moreSet.addAll(set);
                moreSet.add(item);
                System.out.println("moreSet:"+moreSet);
                moresets.add(moreSet);
                System.out.println("moresets:"+moresets);
            }
            powerset.addAll(moresets);
            System.out.println("powerset:"+powerset);
        }
        System.out.println("\n");
        return powerset;
    }

}
