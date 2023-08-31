package PepCoding.LevelUp.Bits;
//import java.util.ArrayList;
//
//class Bits {
//
//    public void offtoOn(int n, int k){
//        int mask = (1 << k);
//        n |= mask;
//        System.out.print(n);
//    }
//
//    public void onToOff(int n, int k){
//        int mask = 1<<k;
//        n &= (~mask);
//        System.out.println(n);
//    }
//
//    public static int countSetBits(int n){
//        int count = 0;
//        for(int i=0; i<32; i++){
//            int mask = (1<<i);
//            if( (mask & n) != 0) count++;
//        }
//        return count;
//    }
//
//    public static int countSetBits02(int n){
//        int count = 0;
//        while(n !=0){
//            if((n & 1) !=0){
//                count ++;
//                n >>>= 1;
//            }
//        }
//        return count;
//    }
//
//    public static int countSetBits03(int n){
//        int count = 0;
//        while(n !=0){
//           n &= (n-1);
//            count ++;
//            }
//        return count;
//    }
//
//    public boolean isPowerOfTwo(int n) {
//        return n > 0 && (n & (n-1)) == 0;
//    }
//
//    public boolean isPowerofFour(int n){
//        if(n <=0 || (n & (n-1)) != 0) // if not a power of 2 it will not be power of 4;
//            return false;
//
//        int count = 0; // triple right shift drop 1 bit from right
//        while(n !=1){
//            count ++;
//            n >>>= 1;
//        }
//        return (count & 1) == 0; // check if even , lsb of even is 0
//    }
//
//    int rowMask=0, colMask=0, diagMask=0, adiagMask=0;
//
//    public int getNQueensPosition(int n, int m, int floor, int tnq) {
//        if (tnq == 0) {
//            return 1;
//        }
//
//        int count = 0;
//
// for (int room = 0; room < m; room++) {
//            int row = floor, col = room;
//
//            if (
//                (colMask & (1<< col)) == 0 &&
//                (diagMask & (1<< (row +col))) == 0  &&
//                (adiagMask & (1<< (row - col + m-1))) == 0 ) {
//
//                colMask ^=  (1<<col);
//                diagMask ^=  (1<< (row+col));
//                adiagMask ^=  (1<< (row-col + m -1));
//
//                count += getNQueensPosition(n, m, floor + 1, tnq - 1);
//
//                colMask ^=  (1<<col);
//                diagMask ^=  (1<< (row+col));
//                adiagMask ^=  (1<< (row-col + m -1));
//            }
//        }
//
//        return count;
//    }
//
//    public int totalNQueens(int n) {
//        return getNQueensPosition(n, n, 0, n);
//    }
//
//    boolean[] row, col, diag, adiag;
//
//    public int nQueen_01(int n, int m, int floor, int tnq, String asf) {
//        if (tnq == 0) {
//            System.out.println(asf);
//            return 1;
//        }
//
//        int count = 0;
//
// for (int room = 0; room < m; room++) {
//            int r = floor, c = room;
//            if (!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
//                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
//                count += nQueen_01(n, m, floor + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
//                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
//            }
//        }
//
//        return count;
//    }
//
//    public int totalNQueensBoolean(int n) {
//        row = new boolean[n];
//        col = new boolean[n];
//        diag = new boolean[n + n - 1];
//        adiag = new boolean[n + n - 1];
//        boolean[][] box = new boolean[n][n];
//        return nQueen_01(n, n, 0, n, "");
//    }
//
//    public class pair{
//        int row = 0;
//        int col = 0;
//
//        pair(int r, int c){
//            this.row = r;
//            this.col = c;
//        }
//    }
//
//    public boolean isvalidPlace(char[][] board, int r, int c, int num){
//        //check in row
//        for(int i=0; i<9; i++)
//            if(board[r][i] - '0' == num)
//                return false;
//
//
//        // check in col
//        for(int i=0; i<9; i++)
//            if(board[i][c] - '0' == num)
//                return false;
//
//
//
//        // check in mat
//        r = (r / 3) * 3;
//        c = (c / 3) * 3;
//
//        for(int i=0; i<3; i++){
//            for(int j=0; j<3; j++){
//                if(board[r+i][c+j] - '0' == num) return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean sudokuSolver(char[][] board, int idx, ArrayList<pair> arr) {
//        if (idx == arr.size()) {
//            return true;
//        }
//
//        pair p = arr.get(idx);
//        int r = p.row;
//        int c = p.col;
//
//        for (int num = 1; num <= 9; num++) {
//            if (isvalidPlace(board, r, c, num)) {
//                board[r][c] = (char) (num + '0');
//                if (sudokuSolver(board, idx + 1, arr))
//                    return true;
//                board[r][c] = '.';
//            }
//        }
//
//        return false;
//    }
//
//        public void solveSudokuBits(char[][] board) {
//            ArrayList<pair> arr = new ArrayList<>();
//
//            for(int i=0; i<9; i++){
//                for(int j=0; j<9; j++){
//                    if(board[i][j] == '.'){
//                        arr.add(new pair(i,j));
//                    }
//                }
//            }
//            sudokuSolver(board, 0, arr);
//        }
//
//
//        public boolean isvalidPlaceBits(char[][] board, int r, int c, int num){
//            //check in row
//            for(int i=0; i<9; i++)
//                if(board[r][i] - '0' == num)
//                    return false;
//
//
//            // check in col
//            for(int i=0; i<9; i++)
//                if(board[i][c] - '0' == num)
//                    return false;
//
//
//
//            // check in mat
//            r = (r / 3) * 3;
//            c = (c / 3) * 3;
//
//            for(int i=0; i<3; i++){
//                for(int j=0; j<3; j++){
//                    if(board[r+i][c+j] - '0' == num) return false;
//                }
//            }
//            return true;
//        }
//
//        public boolean sudokuSolverBits(char[][] board, int idx, ArrayList<pair> arr) {
//            if (idx == arr.size()) {
//                return true;
//            }
//
//            pair p = arr.get(idx);
//            int r = p.row;
//            int c = p.col;
//
//            for (int num = 1; num <= 9; num++) {
//                if (isvalidPlace(board, r, c, num)) {
//                    board[r][c] = (char) (num + '0');
//                    if (sudokuSolver(board, idx + 1, arr))
//                        return true;
//                    board[r][c] = '.';
//                }
//            }
//
//            return false;
//        }
//
//            public void solveSudoku(char[][] board) {
//                ArrayList<pair> arr = new ArrayList<>();
//
//                for(int i=0; i<9; i++){
//                    for(int j=0; j<9; j++){
//                        if(board[i][j] == '.'){
//                            arr.add(new pair(i,j));
//                        }
//                    }
//                }
//                sudokuSolver(board, 0, arr);
//            }
//
//
//
//
////            class Solution {
////                int[] rows, cols;
////                int[][] mat;
////
////                public class pair{
////                    int row = 0;
////                    int col = 0;
////
////                    pair(int r, int c){
////                        this.row = r;
////                        this.col = c;
////                    }
////                }
////
////                // public boolean sudokuSolver(char[][] board, int idx, ArrayList<pair> arr) {
////                //     if (idx == arr.size()) {
////                //         return true;
////                //     }
////
////                //     pair p = arr.get(idx);
////                //     int r = p.row;
////                //     int c = p.col;
////
////                //     for (int num = 1; num <= 9; num++) {
////                //         int mask = 1 << num;
////                //         if ( (rows[r] & mask) == 0 && (cols[c] & mask) ==0 && (mat[r/3][c/3] & mask) == 0 ) {
////                //             board[r][c] = (char) (num + '0');
////
////                //             rows[r] ^= mask;
////                //             cols[c] ^= mask;
////                //             mat[r/3][c/3] ^= mask;
////
////                //             if (sudokuSolver(board, idx + 1, arr))
////                //                 return true;
////
////                //             rows[r] ^= mask;
////                //             cols[c] ^= mask;
////                //             mat[r/3][c/3] ^= mask;
////
////                //             board[r][c] = '.';
////                //         }
////                //     }
////
////                //     return false;
////                // }
////
////                //     public void solveSudoku(char[][] board) {
////                //         ArrayList<pair> arr = new ArrayList<>();
////                //             rows = new int[9];
////                //             cols = new int[9];
////                //             mat = new int[3][3];
////
////                //         for(int i=0; i<9; i++){
////                //             for(int j=0; j<9; j++){
////                //                 if(board[i][j] == '.'){
////                //                     arr.add(new pair(i,j));
////                //                 }
////                //                 else{
////                //                     int mask = (1<< (board[i][j] - '0'));
////                //                     rows[i] ^= mask;
////                //                     cols[j] ^= mask;
////                //                     mat[i/3][j/3] ^= mask;
////                //                 }
////                //             }
////                //         }
////                //         sudokuSolver(board, 0, arr);
////                //     }
////                // }
////}