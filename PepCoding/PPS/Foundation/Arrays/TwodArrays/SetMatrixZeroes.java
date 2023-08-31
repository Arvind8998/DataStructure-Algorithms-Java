class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isColZero = false, isRowZero = false;
        int n = matrix.length, m = matrix[0].length;

        // Finding 0 in first column
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                isColZero = true;
                break;
            }
        }

        // Finding 0 in first row
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                isRowZero = true;
                break;
            }
        }

        // Setting 0 in first row and column to indicate which row and columns are to
        // filled with zero

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Ignoring 1st cell and setting actual zeroes in the matrix

        // Iterating 1st row
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isRowZero) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (isColZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}