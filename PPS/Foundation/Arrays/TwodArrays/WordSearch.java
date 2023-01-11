class Solution {
    public static boolean explore(char[][] board, String word, int[][] dir, int si, int sr, int sc) {
        if (si == word.length()) {
            return true;
        }

        char myChar = board[sr][sc];
        board[sr][sc] = '@';

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length &&
                    board[r][c] == word.charAt(si) && board[r][c] != '@') {
                boolean res = explore(board, word, dir, si + 1, r, c);
                if (res) {
                    board[sr][sc] = myChar;
                    return res;
                }
            }
        }

        board[sr][sc] = myChar;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == word.charAt(0)) {
                    boolean res = explore(board, word, dir, 1, i, j);
                    if (res)
                        return res;
                }
            }
        }
        return false;
    }
}