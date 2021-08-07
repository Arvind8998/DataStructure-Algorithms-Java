class Solution {

    public class pair{
        int row = 0;
        int col = 0;
    
        pair(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    
    public boolean isvalidPlace(char[][] board, int r, int c, int num){
        //check in row
        for(int i=0; i<9; i++)
            if(board[r][i] - '0' == num)
                return false;
        
        
        // check in col
        for(int i=0; i<9; i++)
            if(board[i][c] - '0' == num)
                return false;
    
        
    
        // check in mat
        r = (r / 3) * 3;
        c = (c / 3) * 3;
    
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[r+i][c+j] - '0' == num) return false;
            }
        }
        return true;
    }
    
    public boolean sudokuSolver(char[][] board, int idx, ArrayList<pair> arr) {
        if (idx == arr.size()) {
            return true;
        }
    
        pair p = arr.get(idx);    
        int r = p.row;
        int c = p.col;
    
        for (int num = 1; num <= 9; num++) {
            if (isvalidPlace(board, r, c, num)) {
                board[r][c] = (char) (num + '0');
                if (sudokuSolver(board, idx + 1, arr))
                    return true;
                board[r][c] = '.';
            }
        }
    
        return false;
    }
    
        public void solveSudoku(char[][] board) {
            ArrayList<pair> arr = new ArrayList<>();
    
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    if(board[i][j] == '.'){
                        arr.add(new pair(i,j));
                    }
                }
            }
            sudokuSolver(board, 0, arr);
        }
    }