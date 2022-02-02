class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int potentialSmallestDivisor = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            high = Math.max(nums[i], high);
        }

        if (threshold <= nums.length) {
            return high;
        }

        while (low <= high) {
            int divisor = low + (high - low) / 2;
            if (isSmallestDivisor(divisor, nums, threshold)) {
                potentialSmallestDivisor = divisor;
                high = divisor - 1;
            } else {
                low = divisor + 1;
            }
        }
        return potentialSmallestDivisor;
    }

    public static boolean isSmallestDivisor(int divisor, int[] nums, int threshold) {
        int minDivisor = 0;
        for (int i = 0; i < nums.length; i++) {
            minDivisor += (int) Math.ceil((nums[i] * 1.0) / divisor);
        }
        return minDivisor <= threshold;
    }
}