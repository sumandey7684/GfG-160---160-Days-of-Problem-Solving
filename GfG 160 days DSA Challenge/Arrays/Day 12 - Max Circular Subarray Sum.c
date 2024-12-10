// User function Template for C

int kadane(int arr[], int n) {
    int max_current = arr[0], max_global = arr[0];
    for (int i = 1; i < n; i++) {
        max_current = (arr[i] > max_current + arr[i]) ? arr[i] : max_current + arr[i];
        max_global = (max_global > max_current) ? max_global : max_current;
    }
    return max_global;
}

int circularSubarraySum(int arr[], int n) {
    int max_kadane = kadane(arr, n);

    int total_sum = 0;
    for (int i = 0; i < n; i++) {
        total_sum += arr[i];
    }

    for (int i = 0; i < n; i++) {
        arr[i] = -arr[i]; // Invert array elements
    }
    int min_kadane = kadane(arr, n);
    int max_circular = total_sum + min_kadane; 

    if (max_circular == 0) {
        return max_kadane;
    }
    return (max_kadane > max_circular) ? max_kadane : max_circular;
}