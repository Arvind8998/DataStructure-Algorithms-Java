class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        if (h == piles.length)
            return max;

        int low = 0, hi = max;
        int minSpeed = Integer.MAX_VALUE;

        while (low <= hi) {
            int speed = low + (hi - low) / 2;
            if (isPossibleToEat(piles, h, speed)) {
                minSpeed = speed;
                hi = speed - 1;
            } else {
                low = speed + 1;
            }
        }
        return minSpeed;

    }

    public static boolean isPossibleToEat(int[] piles, int h, int speed) {
        int minHours = 0;
        for (int i = 0; i < piles.length; i++) {
            minHours += (int) Math.ceil((piles[i] * 1.0) / speed);
        }
        return minHours <= h;

    }
}