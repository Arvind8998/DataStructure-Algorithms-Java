class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxWater = 0;

        while (low < high) {
            int w = high - low;
            int h = Math.min(height[low], height[high]);
            maxWater = Math.max(maxWater, w * h);

            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxWater;
    }
}