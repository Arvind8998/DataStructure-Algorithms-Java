import java.util.Arrays;
import java.util.Scanner;
    
public class GoldMine {

    public static int goldMine(int sr, int sc, int[][] dir, int[][] arr, int[][] dp){
        int n = arr.length, m = arr[0].length;
        if(sc == m-1){
            return dp[sr][sc] = arr[sr][sc];
        }

        if(dp[sr][sc] != -1) return dp[sr][sc];
        int maxGold = 0;

        for(int[] d : dir){
            int r = sr + d[0];
            int c = sc + d[1];
            if( r >=0 && c >=0 && r< n && c < m)
            maxGold = Math.max(maxGold, goldMine(r, c, dir, arr, dp) + arr[sr][sc]);
        }
        return dp[sr][sc] = maxGold;
    }

    public static  int getGold(){
        int [][] arr = {{10, 33, 13, 15},
                      {22, 21, 04, 1},
                      {5, 0, 2, 3},
                      {0, 6, 14, 2}};
        
        int[][] dir = { {0,1}, {1,1}, {-1,1}};
        int n = arr.length, m = arr[0].length;
    
        int[][] dp = new int[n][m];
        for(int[] d: dp)
            Arrays.fill(d, -1);
        int maxGold = 0;
    
        for(int r=0; r<n; r++){
            maxGold = Math.max(maxGold, goldMine(r, 0, dir, arr, dp));
        }
        return maxGold;
    }
    
    public static void main(String[] args){
        System.out.println("Max gOLD IS" + " "  + getGold());
    }
}
