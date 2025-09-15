package src.LeetCode.ARRAY;

import java.util.*;

/**
 * LeetCode 56. Merge Intervals
 *
 * Problem Statement:
 * Given an array of intervals where intervals[i] = [start, end], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: [1,3] and [2,6] overlap, so they are merged into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 *
 * Goal:
 * Merge overlapping intervals and return the result.
 *
 * Approach:
 * 1. Sort intervals by their start time.
 * 2. Use a list to store merged intervals.
 * 3. Traverse through intervals:
 *    - If current interval overlaps with the last merged one, extend the end.
 *    - Otherwise, add it as a new interval.
 */

public class LC_56_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Use a list to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 3: Traverse intervals
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                // Overlap → extend the current interval's end
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // No overlap → move to next interval
                current = interval;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_56_MergeIntervals obj = new LC_56_MergeIntervals();

        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(obj.merge(intervals1)));
        // [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = {{1,4},{4,5}};
        System.out.println(Arrays.deepToString(obj.merge(intervals2)));
        // [[1, 5]]

        int[][] intervals3 = {{1,10},{2,6},{8,9}};
        System.out.println(Arrays.deepToString(obj.merge(intervals3)));
        // [[1, 10]]
    }
}

/**
 * Time Complexity:
 * - Sorting: O(n log n)
 * - Merge scan: O(n)
 * Overall: O(n log n)
 *
 * Space Complexity:
 * - O(n) for output list
 */

