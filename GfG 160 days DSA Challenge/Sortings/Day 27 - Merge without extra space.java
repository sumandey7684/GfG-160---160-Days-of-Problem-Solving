// User function Template for Java

class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        for (int i = n - 1, j = 0; i >= 0 && j < m; i--, j++) {
            if (a[i] > b[j]) {
                int t = a[i];
                a[i] = b[j];
                b[j] = t;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
