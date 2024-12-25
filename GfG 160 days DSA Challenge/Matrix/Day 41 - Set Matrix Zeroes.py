class Solution:
    def setMatrixZeroes(self, mat):
        n = len(mat)
        m = len(mat[0])
        rows = [False] * n
        cols = [False] * m

        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    rows[i] = True
                    cols[j] = True

        for i in range(n):
            for j in range(m):
                if rows[i] or cols[j]:
                    mat[i][j] = 0
