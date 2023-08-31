package PepCoding.LevelUp.DP;
import java.io.*;
import java.util.*;

// https://www.geeksforgeeks.org/longest-decreasing-subsequence/
class LongestDecreasingSubsequenceGFG {

    public static int LIS_LR(int[] nums, int[] dp) {
        int n = nums.length, maxLength = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }

    // starting at biggest no start at lds-> LONGEST DECREASING SUBSEQUENCE
    public static int LIS_RL(int[] nums, int[] dp) {
        int n = nums.length, maxLength = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }

    public static int LongestBitonicSequence(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];

        LIS_LR(nums, LIS);
        LIS_RL(nums, LDS);


        // System.out.println(null);

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, LIS[i] + LDS[i] - 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 9, 6, 4, 5, 7, 3, 2, 4 };
        System.out.println(LongestBitonicSequence(arr));
    }

}