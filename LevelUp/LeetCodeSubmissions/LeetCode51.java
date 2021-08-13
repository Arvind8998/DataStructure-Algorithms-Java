import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[] col, row, diag, antiDiag;
    
    public void getQueenPositions(List<List<String>> ans, int n, int floor, int tnq, char[][] board){
        
    if(tnq == 0){
       fillQueenPositions(board, ans, n);
        return;
    }
            for(int room=0; room<n; room++){
                int r = floor, c= room;
                
                if(!col[c]  && !diag[r+c] && !antiDiag[r-c + n-1]){
                    
                    col[c] = diag[r+c] = antiDiag[r-c + n-1] = true;
                    board[r][c] = 'Q';
                    getQueenPositions(ans, n, floor+1, tnq-1,  board);
                    col[c] = diag[r+c] = antiDiag[r-c + n-1] = false;
                    board[r][c] = '.';
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
        row = new boolean[n];
        col = new boolean[n];
        diag = new boolean[n+n-1];
        antiDiag = new boolean[n+n-1];
        
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
