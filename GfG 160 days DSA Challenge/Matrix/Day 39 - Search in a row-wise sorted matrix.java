class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int n = mat.length;       // num of row
        int m = mat[0].length;    // num of column

        int row = 0, col = m - 1;

        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                return true;
            } else if (mat[row][col] > x) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
