import java.util.ArrayList;
import java.util.List;

class Solution {
      int rowMask=0, colMask=0, diagMask=0, adiagMask=0;
    
    public void getQueenPositions(List<List<String>> ans, int n, int floor, int tnq, char[][] board){
        
    if(tnq == 0){
       fillQueenPositions(board, ans, n);
        return;
    }
            for(int room=0; room<n; room++){
                int row = floor, col = room;
                
                if( 
                (colMask & (1<< col)) == 0 &&
                (diagMask & (1<< (row +col))) == 0  &&
                (adiagMask & (1<< (row - col + n-1))) == 0 ){
                    
                    colMask ^=  (1<<col);
                    diagMask ^=  (1<< (row+col));
                    adiagMask ^=  (1<< (row-col + n -1));
                    
                    board[row][col] = 'Q';
                    
                    getQueenPositions(ans, n, floor+1, tnq-1,  board);
                    
                    colMask ^=  (1<<col);
                    diagMask ^=  (1<< (row+col));
                    adiagMask ^=  (1<< (row-col + n -1));
                    board[row][col] = '.';
                }
            }
        
    }
    
    public void fillQueenPositions(char[][] board, List<List<String>> ans, int n){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(board[i][j] == 'Q'){
                    sb.append('Q');
                }
                else sb.append('.');
            }
            list.add(sb.toString());
        }
        ans.add(list);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        getQueenPositions(ans, n, 0, n, board);
        return ans;
    }
}
