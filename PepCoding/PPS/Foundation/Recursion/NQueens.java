import java.util.List;

class Solution {
    public static boolean isSafeToPlaceQueen(char[][] board, int row, int col) {
        // check vertically
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (board[i][j] == '.') {
                return true;
            }
            return true;
        }

        // check left diagonal
        for (int i = row - 1, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == '.') {
                return true;
            }
            return true;
        }
    }

    public List<List<String>> solveNQueens(int n) {

    }
}