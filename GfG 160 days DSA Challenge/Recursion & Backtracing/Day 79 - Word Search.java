class Solution {
    public static boolean traverse(char[][] mat, String word, int r, int c, int wi) {
        if (r < mat.length && r >= 0 && c < mat[0].length && c >= 0) {
            if (wi == word.length()) {
                return true;
            }
            if (mat[r][c] != word.charAt(wi)) {
                return false;
            }

            char temp = mat[r][c];
            mat[r][c] = '-';

            boolean found = traverse(mat, word, r + 1, c, wi + 1) ||
                            traverse(mat, word, r - 1, c, wi + 1) ||
                            traverse(mat, word, r, c + 1, wi + 1) ||
                            traverse(mat, word, r, c - 1, wi + 1);

            mat[r][c] = temp;
            return found;
        }
        return false;
    }

    public static boolean isWordExist(char[][] mat, String word) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (traverse(mat, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
