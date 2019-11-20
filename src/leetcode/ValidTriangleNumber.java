package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-triangle-number/solution/
 */

public class ValidTriangleNumber {

    public static void main(String[] args) {
        int[] nums = {3,3,5};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }
}
