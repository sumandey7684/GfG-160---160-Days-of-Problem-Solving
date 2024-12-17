// User function Templ

class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        int[] mergedArray = merge(a, b);
        return mergedArray[k - 1];
    }
    
    public int[] merge(int[] a, int[] b) {
        int[] mergedArray = new int[a.length + b.length];
        int i = 0, j = 0, tempIndex = 0;

        // Merge elements from both arrays in sorted order
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                mergedArray[tempIndex++] = a[i++];
            } else {
                mergedArray[tempIndex++] = b[j++];
            }
        }

        // Copy remaining elements from array `a`, if any
        while (i < a.length) {
            mergedArray[tempIndex++] = a[i++];
        }

        // Copy remaining elements from array `b`, if any
        while (j < b.length) {
            mergedArray[tempIndex++] = b[j++];
        }

        return mergedArray;
    }
}
