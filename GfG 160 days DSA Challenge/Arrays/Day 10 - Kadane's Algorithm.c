// User function Template for 

int maxSubarraySum(int arr[], int n) {
    int max_sum = arr[0]; // To store the maximum subarray sum
    int current_sum = arr[0]; // To store the current subarray sum

    for (int i = 1; i < n; i++) {
        current_sum = (current_sum + arr[i] > arr[i]) ? current_sum + arr[i] : arr[i];
        max_sum = (max_sum > current_sum) ? max_sum : current_sum;
    }

    return max_sum;
}