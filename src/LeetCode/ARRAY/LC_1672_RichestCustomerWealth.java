package src.LeetCode.ARRAY;

/**
 * ✅ LeetCode 1672: Richest Customer Wealth
 *
 * 💬 Problem Statement:
 * You are given an m x n integer grid 'accounts' where accounts[i][j] is the amount of money
 * the i-th customer has in the j-th bank. Return the wealth that the richest customer has.
 *
 * A customer's wealth is the sum of money they have in all their bank accounts.
 * The richest customer is the one with the maximum wealth.
 *
 * 🔹 Example:
 * Input: accounts = [[1,2,3], [3,2,1], [4,3,1]]
 * Output: 8
 * Explanation: The 3rd customer has wealth = 4 + 3 + 1 = 8, which is the maximum.
 */
public class LC_1672_RichestCustomerWealth {

    // Method to find the maximum wealth among all customers
    public int maximumWealth(int[][] accounts) {
        int max = 0;  // Stores max wealth found so far

        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;  // Sum of current customer's wealth

            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];  // Add each bank's money
            }

            max = Math.max(max, sum);  // Update max wealth if needed
        }

        return max;  // Return final richest wealth
    }

    // Sample test case for quick testing
    public static void main(String[] args) {
        LC_1672_RichestCustomerWealth obj = new LC_1672_RichestCustomerWealth();

        int[][] accounts = {
                {1, 2, 3},
                {3, 2, 1},
                {4, 3, 1}
        };

        System.out.println("Maximum Wealth: " + obj.maximumWealth(accounts)); // Output: 8
    }
}
