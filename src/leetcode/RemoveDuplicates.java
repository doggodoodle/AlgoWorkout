package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2,3};
        System.out.println(findDuplicates(nums));
    }
}
