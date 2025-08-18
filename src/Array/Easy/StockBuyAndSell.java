package src.Array.Easy;

/*
LeetCode 121. Best Time to Buy and Sell Stock

Problem:
You are given an array 'prices' where prices[i] is the price of a given stock on the i-th day.
You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve. If no profit is possible, return 0.

Example:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price=1) and sell on day 5 (price=6), profit = 6-1 = 5.

Input: [7,6,4,3,1]
Output: 0
Explanation: No profit possible.
*/

public class StockBuyAndSell {

    // Brute Force Approach - O(n^2)
    static void stockBuyAndSellBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        System.out.println("Max Profit (Brute Force): " + maxProfit);
    }

    // Optimized Approach - O(n)
    static void stockBuyAndSellOptimized(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price); // track min price so far
            maxProfit = Math.max(maxProfit, price - minPrice); // track max profit so far
        }

        System.out.println("Max Profit (Optimized): " + maxProfit);
    }

    public static void main(String[] args) {
        int[] stock1 = {7, 1, 5, 3, 6, 4};
        int[] stock2 = {7, 6, 4, 3, 1};

        System.out.println("Test Case 1:");
        stockBuyAndSellBruteForce(stock1);
        stockBuyAndSellOptimized(stock1);

        System.out.println("\nTest Case 2:");
        stockBuyAndSellBruteForce(stock2);
        stockBuyAndSellOptimized(stock2);
    }
}