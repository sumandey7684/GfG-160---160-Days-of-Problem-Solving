class Solution {

    public int peakElement(int[] arr) {
        int n = arr.length;

        // if only one element, it's the ans
        if (n == 1) {
            return 0;
        }

        // Check first
        if (arr[0] > arr[1]) {
            return 0;
        }

        // Check last
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }

        // Check middle
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }

        return 0;
    }
}
