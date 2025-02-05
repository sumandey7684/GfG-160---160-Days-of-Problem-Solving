class Solution {
    static class Cell {
        int row;
        int col;
        Cell(int x, int y) {
            this.row = x;
            this.col = y;
        }
    }

    static void solveSudoku(int[][] mat) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] subMatrix = new int[9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (mat[row][col] == 0) continue;
                rows[row] |= (1 << mat[row][col]);
                cols[col] |= (1 << mat[row][col]);
                subMatrix[(row / 3) * 3 + (col / 3)] |= (1 << mat[row][col]);
            }
        }

        solveThis(mat, rows, cols, subMatrix);
    }

    static boolean solveThis(int[][] mat, int[] rows, int[] cols, int[] subMatrix) {
        Cell freeCell = findPlace(mat);
        if (freeCell == null) return true;

        int row = freeCell.row;
        int col = freeCell.col;
        int sub = (row / 3) * 3 + (col / 3);

        for (int num = 1; num <= 9; num++) {
            if (((1 << num) & rows[row]) == 0 &&
                ((1 << num) & cols[col]) == 0 &&
                ((1 << num) & subMatrix[sub]) == 0) {

                mat[row][col] = num;
                rows[row] |= (1 << num);
                cols[col] |= (1 << num);
                subMatrix[sub] |= (1 << num);

                if (solveThis(mat, rows, cols, subMatrix)) return true;

                mat[row][col] = 0;
                rows[row] ^= (1 << num);
                cols[col] ^= (1 << num);
                subMatrix[sub] ^= (1 << num);
            }
        }
        return false;
    }

    static Cell findPlace(int[][] mat) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (mat[row][col] == 0) return new Cell(row, col);
            }
        }
        return null;
    }
}
