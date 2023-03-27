class Solution {
    public static int count = 0;

    public static void findNumberOfSubsets(int[] nums, int idx, String sos, int sumSoFar, int target) {
        if (idx == nums.length) {
            if (sumSoFar == target) {
                System.out.println("Matched with target");
                count += 1;
            }
            return;
        }

        findNumberOfSubsets(nums, idx + 1, sos + nums[idx] + ", ", sumSoFar + nums[idx], target);
        findNumberOfSubsets(nums, idx + 1, sos, sumSoFar, target);
    }

    public int findTargetSumWays(int[] nums, int target) {
        findNumberOfSubsets(nums, 0, "", 0, target);
        return count;
    }
}