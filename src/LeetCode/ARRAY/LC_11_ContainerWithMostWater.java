package src.LeetCode.ARRAY;

/*
 🔶 LeetCode 11 - Container With Most Water

 🔹 Problem Statement:
 Given `n` non-negative integers `height[0], height[1], ..., height[n - 1]`, where each represents a point at coordinate (i, height[i]),
 n vertical lines are drawn such that the two endpoints of the line `i` are at (i, 0) and (i, height[i]).
 Find two lines, which together with the x-axis forms a container, such that the container contains the most water.

 🔸 Example:
 Input:  height = [1,8,6,2,5,4,8,3,7]
 Output: 49

 ✅ Goal:
 Find the maximum area formed between two lines using an efficient two-pointer approach.
*/

public class LC_11_ContainerWithMostWater {

    // ✅ Two-pointer optimal solution
    public int maxArea(int[] height) {
        int left = 0;                     // Start from left end
        int right = height.length - 1;    // Start from right end
        int maxArea = 0;                  // Track the maximum area

        // Move the pointers toward each other
        while (left < right) {
            // Calculate height and area
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = minHeight * width;

            // Update maxArea if needed
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;  // Move left pointer forward
            } else {
                right--; // Move right pointer backward
            }
        }

        return maxArea;
    }

    // 🧪 Test the code
    public static void main(String[] args) {
        LC_11_ContainerWithMostWater solution = new LC_11_ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};  // Example input
        int result = solution.maxArea(height);
        System.out.println("Max Area: " + result);  // Expected output: 49
    }
}
