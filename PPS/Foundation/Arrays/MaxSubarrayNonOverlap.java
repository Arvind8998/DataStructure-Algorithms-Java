class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int sum = 0;

        // Left to right
        for (int i = 0; i < n; i++) {
            if (i < firstLen) {
                sum += nums[i];
                dp1[i] = sum;
            } else {
                sum += nums[i] - nums[i - firstLen];
                dp1[i] = Math.max(dp1[i - 1], sum);
            }
        }
        sum = 0;

        // Right to left

        for (int i = n - 1; i >= 0; i--) {
            if (i + secondLen >= n) {
                sum += nums[i];
                dp2[i] = sum;
            } else {
                sum += nums[i] - nums[i + secondLen];
                dp2[i] = Math.max(dp2[i + 1], sum);
            }
        }

        int ans = 0;

        for (int i = firstLen; i < n - secondLen; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i + 1]);
        }

        sum = 0;
        dp1 = new int[n];
        dp2 = new int[n];

        // Left to right second length first
        for (int i = 0; i < n; i++) {
            if (i < secondLen) {
                sum += nums[i];
                dp1[i] = sum;
            } else {
                sum += nums[i] - nums[i - secondLen];
                dp1[i] = Math.max(dp1[i - 1], sum);
            }
        }
        sum = 0;

        // Right to left first length last

        for (int i = n - 1; i >= 0; i--) {
            if (i + firstLen >= n) {
                sum += nums[i];
                dp2[i] = sum;
            } else {
                sum += nums[i] - nums[i + firstLen];
                dp2[i] = Math.max(dp2[i + 1], sum);
            }
        }

        for (int i = secondLen-1; i < n - firstLen; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i + 1]);
        }

        return ans;

    }
}