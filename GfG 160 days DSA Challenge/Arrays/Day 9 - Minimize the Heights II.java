// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int k) {
        // Handle edge cases
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return 0;

        // Step 1: Sort the array
        Arrays.sort(arr);

        int n = arr.length;
        int diff = arr[n - 1] - arr[0]; // Initial difference

        // Step 2: Iterate through the array and calculate new possible differences
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 1; i < n; i++) {
            // Check if arr[i] - k drops below 0, skip if so
            if (arr[i] - k < 0) continue;

            int newMin = Math.min(smallest, arr[i] - k);
            int newMax = Math.max(largest, arr[i - 1] + k);

            diff = Math.min(diff, newMax - newMin);
        }

        return diff;
    }
}