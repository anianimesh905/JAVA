package src.Codeforces;
/*
 * Codeforces Problem: 50A - Domino piling
 * Link: https://codeforces.com/problemset/problem/50/A
 *
 * Statement:
 * You are given a board of size M×N squares. You are given an unlimited number
 * of domino pieces (2×1). Each domino covers 2 squares. Find the maximum number
 * of dominoes that can be placed on the board without overlap.
 *
 * Input:
 * - Two integers M, N
 *
 * Output:
 * - Maximum number of dominoes
 *
 * Example:
 * Input: 2 4
 * Output: 4
 *
 * Approach:
 * - Each domino covers 2 cells
 * - Answer = (M * N) / 2
 */

import java.util.*;

public class CF_50A_DominoPiling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println((m * n) / 2);
    }
}
