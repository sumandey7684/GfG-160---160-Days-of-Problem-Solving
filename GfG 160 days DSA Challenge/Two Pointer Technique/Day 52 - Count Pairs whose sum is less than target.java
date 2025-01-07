class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
