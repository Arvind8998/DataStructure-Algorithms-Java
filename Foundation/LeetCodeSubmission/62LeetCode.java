class Solution {
    
    public int mazePaths(int sr, int sc, int er, int ec, String ans, int[][] dir, String[] dirS, ArrayList<String> output){
        if(sr == er && sc == ec){
            output.add(ans);
            for(String el: output)
               
            return 1;
        }
        
        int count = 0;
        
        for(int d=0; d<dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r>= 0 && c >=0 && r<= er && c<=ec){
                count += mazePaths(r, c, er, ec, ans+dirS[d], dir, dirS, output);
            }
        }
        return count;
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dir = {{0,1}, {1,0}};
        String[] dirS = {"Right", "Down"};
        ArrayList<String> output = new ArrayList<>();
        return mazePaths(0, 0, m-1, n-1,"", dir, dirS, output);
    }
}