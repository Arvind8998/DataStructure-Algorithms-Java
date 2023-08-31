package PepCoding.LevelUp.LeetCodeSubmissions;
class Solution {
    int rowMask=0, colMask=0, diagMask=0, adiagMask=0;

    public int getNQueensPosition(int n, int m, int floor, int tnq) {
        if (tnq == 0) {
            return 1;
        }

        int count = 0;
        
 for (int room = 0; room < m; room++) {
            int row = floor, col = room;
     
            if ( 
                (colMask & (1<< col)) == 0 &&
                (diagMask & (1<< (row +col))) == 0  &&
                (adiagMask & (1<< (row - col + m-1))) == 0 ) {
                
                colMask ^=  (1<<col);
                diagMask ^=  (1<< (row+col));
                adiagMask ^=  (1<< (row-col + m -1));
                
                count += getNQueensPosition(n, m, floor + 1, tnq - 1);
                
                colMask ^=  (1<<col);
                diagMask ^=  (1<< (row+col));
                adiagMask ^=  (1<< (row-col + m -1));
            }
        }

        return count;
    }
    
    public int totalNQueens(int n) {
        return getNQueensPosition(n, n, 0, n);
    }
}