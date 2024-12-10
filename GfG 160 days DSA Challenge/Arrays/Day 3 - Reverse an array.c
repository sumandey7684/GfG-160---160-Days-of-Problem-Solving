// User function Template for C

void reverseArray(int arr[], int n) {
    int left = 0, right = n - 1;

    while (left < right) {
        arr[left] ^= arr[right];
        arr[right] ^= arr[left];
        arr[left] ^= arr[right];
        left++;
        right--;
    }
}