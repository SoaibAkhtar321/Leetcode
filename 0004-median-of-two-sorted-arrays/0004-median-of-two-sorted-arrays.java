class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] small = nums1.length < nums2.length ? nums1 : nums2;
        int[] large = nums1.length < nums2.length ? nums2 : nums1;

        int m = small.length, n = large.length;
        int totalLength = m + n;

        int low = 0, high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (totalLength + 1) / 2 - partitionX;

            int l1 = (partitionX == 0) ? Integer.MIN_VALUE : small[partitionX - 1];
            int r1 = (partitionX == m) ? Integer.MAX_VALUE : small[partitionX];

            int l2 = (partitionY == 0) ? Integer.MIN_VALUE : large[partitionY - 1];
            int r2 = (partitionY == n) ? Integer.MAX_VALUE : large[partitionY];

            if (l1 <= r2 && l2 <= r1) {
                if (totalLength % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } 
            else if (l1 > r2) {
                high = partitionX - 1;
            } 
            else {
                low = partitionX + 1;
            }
        }

        return 0.0;
    }
}