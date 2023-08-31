
// package Foundation.Recursion;
import java.util.*;

public class KnightTour {

    public static boolean knightTour(int sr, int sc, int[][] board, int[] dirX, int[] dirY, int move) {
        board[sr][sc] = move;

        if (move == 63) {
            return true;
        }

        boolean res = false;
        for (int d = 0; d < 8; d++) {
            int r = sr + dirX[d];
            int c = sc + dirY[d];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == -1) {
                res = knightTour(r, c, board, dirX, dirY, move + 1);
                if (res) {
                    return res;
                }
            }

        }
        board[sr][sc] = -1;
        return res;
    }

    public static void main(String[] args) {
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        int n = 8;
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = -1;
            }
        }

        knightTour(0, 0, board, xMove, yMove, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
