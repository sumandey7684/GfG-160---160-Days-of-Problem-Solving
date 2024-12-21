class Solution {
    static void rotateby90(int mat[][]) {
        int n = mat.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[j][i];
                mat[j][i] = mat[n - 1 - j][i];
                mat[n - 1 - j][i] = temp;
            }
        }
    }
}
