// User function Template for C

// Function to rotate an array by d elements in counter-clockwise direction.
void rotateArr(int arr[], int n, int d) {
    d=d%n;
    if (d==0)
    return;
    int temp[d];
    for (int i = 0; i<d; i++)
    {
        temp[i] = arr[i];
    }
    for (int i=d; i<n; i++)
    {
        arr[i-d]=arr[i];
    }
    for (int i = 0; i<d; i++)
    {
        arr[n-d+i] = temp[i];
    }
}