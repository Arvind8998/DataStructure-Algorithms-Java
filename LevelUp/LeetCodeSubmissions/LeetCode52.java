class Solution {
    boolean[] row, col, diag, adiag;

    public int nQueen_01(int n, int m, int floor, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        
 for (int room = 0; room < m; room++) {
            int r = floor, c = room;
            if (!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nQueen_01(n, m, floor + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        return count;
    }
    
    public int totalNQueens(int n) {
        row = new boolean[n];
        col = new boolean[n];
        diag = new boolean[n + n - 1];
        adiag = new boolean[n + n - 1];
        boolean[][] box = new boolean[n][n];
        return nQueen_01(n, n, 0, n, "");
    }
}