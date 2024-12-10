// User function Template for Java

class Solution {
    public int maxOnes(int[] arr, int k) {
        int maxLength = 0; // To store the maximum length of 1s
        int zeroCount = 0; // To count the number of zeros in the current window
        int left = 0; // Left pointer of the sliding window

        for (int right = 0; right < arr.length; right++) {
            // Expand the window by including the current element
            if (arr[right] == 0) {
                zeroCount++;
            }

            // If the number of zeros exceeds k, shrink the window from the left
            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}