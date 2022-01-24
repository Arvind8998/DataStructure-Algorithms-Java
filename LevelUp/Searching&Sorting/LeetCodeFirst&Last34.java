class Solution {
    public int[] searchRange(int[] nums, int target) {
        int si = 0, ei = nums.length - 1, mid = 0;
        int[] result = new int[2];
        Arrays.fill(result,-1);

        while (si <= ei) {
            mid = (si + ei) / 2;
            if (nums[mid] == target) {
                result[0] = mid;
                ei = mid - 1;
                // continue search on left for first occurence
            } else if (nums[mid] < target)
                si = mid + 1;
            else if (nums[mid] > target)
                ei = mid - 1;
        }
        si =0; ei = nums.length-1;

        while (si <= ei) {
            mid = (si + ei) / 2;
            if (nums[mid] == target) {
                result[1] = mid;
                si = mid + 1;
                // continue search on right for second occurence
            } else if (nums[mid] < target)
                si = mid + 1;
            else if (nums[mid] > target)
                ei = mid - 1;
        }
        return result;

    }
}