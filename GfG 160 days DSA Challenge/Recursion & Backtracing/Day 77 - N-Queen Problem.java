class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n];
        solveNQueen(0, n, board, result);
        return result;
    }

    private void solveNQueen(int col, int n, int[] board, ArrayList<ArrayList<Integer>> result) {
        if (col == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(board[i] + 1);
            }
            result.add(solution);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[col] = row;
                solveNQueen(col + 1, n, board, result);
            }
        }
    }

    private boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < col; i++) {
            if (board[i] == row || Math.abs(board[i] - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }
}
