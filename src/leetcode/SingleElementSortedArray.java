package leetcode;

/**
 * Created by ritvikmathur on 5/14/17.
 * https://leetcode.com/problems/single-element-in-a-sorted-array/#/solutions
 */
public class SingleElementSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low < high) {
            int mid = low + (high - low)/2;
            System.out.println("mid:"+mid);
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1])
                return nums[mid];
            else if(nums[mid] == nums[mid+1] && mid % 2 == 0)
                low = mid+1;
            else if(nums[mid] == nums[mid-1] && mid % 2 == 1)
                low = mid+1;
            else
                high = mid-1;
        }
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{0,1}));
    }
}
