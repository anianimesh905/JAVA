package src.Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Leaders in an Array
 *
 * A leader in an array is an element that is greater than or equal to all the elements
 * to its right. The rightmost element is always a leader.
 *
 * Example:
 * Input:  [16, 17, 4, 3, 5, 2]
 * Output: [17, 5, 2]
 */
public class LeaderInArray {

    // Function to find leaders
    public static List<Integer> leaders(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int max = nums[nums.length - 1];
        res.add(max); // last element is always a leader

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= max) {
                res.add(nums[i]);
                max = nums[i];
            }
        }

        // reverse to maintain original left-to-right order
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {16, 17, 4, 3, 5, 2};

        List<Integer> leadersList = leaders(nums);

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Leaders in the Array: " + leadersList);
    }
}
