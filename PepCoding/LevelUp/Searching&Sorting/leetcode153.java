class Solution {
    public int findMin(int[] nums) {
        int si = 0, ei = nums.length - 1;
        int mid = 0;
        if (nums[si] <= nums[ei]) {
            return nums[0];
        }
        while (si <= ei) {
            mid = (si + ei) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            else if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }  else if (nums[si] <= nums[mid]) {
                si = mid + 1;
            } else if (nums[mid] <= nums[ei]) {
                ei = mid - 1;
            }
        }
        return -1;
    }
}