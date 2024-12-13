// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        int min = arr[0];
        int lo = 1;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (min <= arr[mid]) {
                lo = mid + 1;
            } else {
                // min > arr[mid]
                hi = mid;
            }
        }
        return Math.min(min, arr[hi]);
    }
}
