class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int si = 0, ei = nums1.length;
        int totalEl = nums1.length + nums2.length;

        while (si <= ei) {
            int aleft = (si + ei) / 2;
            int bleft = (totalEl + 1) / 2 - aleft;
        System.out.print(bleft);
            int alm1 = aleft == 0 ? Integer.MIN_VALUE : nums1[aleft - 1];
            int al = aleft == nums1.length ? Integer.MAX_VALUE : nums1[aleft];
            int blm1 = bleft == 0 ? Integer.MIN_VALUE : nums2[bleft - 1];
            int bl = bleft == nums2.length ? Integer.MAX_VALUE : nums2[bleft];

            if (alm1 <= bl && blm1 <= al) {
                double median = 0;
                if (totalEl % 2 == 0) {
                    int leftMax = Math.max(alm1, blm1);
                    int rightMin = Math.min(al, bl);
                    median = (leftMax + rightMin) / 2.0;
                } else {
                    median = Math.max(alm1, blm1);
                }
                return median;
            } else if (alm1 > bl) {
                ei = aleft - 1;
            } else if (blm1 > al) {
                si = aleft + 1;
            }
        }
        return -1;
    }
}