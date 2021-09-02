public class Dp{

    public static void display(int[] dp){
        for(int a : dp){
            System.out.print(a +" ");
        }
    }

    public static void display2d(int[][] dp){
        for(int[] a : dp){
            display(a);
        }
        System.out.println();
    }

    public static int fibo_memo(int n, int[] dp){
        if(n <=1) return dp[n] = n;
        int ans = fibo_memo(n-1,dp) + fibo_memo(n-2,dp);
        return dp[n] = ans;
    }

    public static int[] fibo_tabu(int N, int[] dp){
        for(int n=0; n<=N; n++){
            if(n <=1){
               dp[n] = n;
               continue;
            }
            int ans = dp[n-1] + dp[n-2];
            dp[n] = ans;
        }
        return dp;
    }

    public static int fibo_opti(int N){
        int a = 0, b=1;

        for(int i=2; i<=N; i++){
            int sum = a + b;
            a= b;
            b= sum;
        }
        return b;
    }

    public static void fibo(){
        int n = 5;
        int[] dp = new int[n+1];
        fibo_memo(n, dp);   
        fibo_tabu(n, dp);
        // System.out.print(fibo_opti(n));
        display(dp);
    }

    public static int mazePath(int sr, int sc, int er, int ec, int[][]dp, int[][] dir){
        if(sr == er && sc == ec){
            return dp[sr][sc] = 1;
        }
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }

        int count = 0;

        for(int d=0; d<dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >=0 && c >=0 && r <= er && c <= ec ){
                count += mazePath(r, c, er, ec, dp, dir);
            }
        }
        return dp[sr][sc] = count;
    }

    public static int mazePathJump(int sr, int sc, int er, int ec, int[][]dp, int[][] dir, int R){
        if(sr == er && sc == ec){
            return dp[sr][sc] = 1;
        }
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }

        int count = 0;

        for(int d=0; d<dir.length; d++){
            for(int radius=1; radius<R; radius++){
                int r = sr + dir[d][0]*radius;
                int c = sc + dir[d][1]*radius;
            if(r >=0 && c >=0 && r <= er && c <= ec ){
                count += mazePathJump(r, c, er, ec, dp, dir, R);
            }
        }
        }
        return dp[sr][sc] = count;
    }

    public static void main(String[] args){
        int sr = 0, sc =0, er =2, ec= 2;
        int[][] dir = { {0,1}, {1,0}, {1,1}};
        int radius = Math.max(er,ec);

        // fibo();
        int[][] dp = new int[er+1][ec+1];
        System.out.print(mazePathJump(sr, sc, er-1, ec-1, dp, dir, radius));
        display2d(dp);
    }
}
