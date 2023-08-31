class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;

        int i = 0, j = height.length-1;

        while (i < j) {
            int width = j - i;
            int heightVal = Math.min(height[i], height[j]);

            maxWater = Math.max(maxWater, width * heightVal);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxWater;
    }
}