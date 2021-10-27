public class Dp{

    public static void display(int[] dp){
        for(int a : dp){
            System.out.print(a +" ");
        }
        System.out.println();
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

    public static int mazePath__memo(int sr, int sc, int er, int ec, int[][]dp, int[][] dir){
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
                count += mazePath__memo(r, c, er, ec, dp, dir);
            }
        }
        return dp[sr][sc] = count;
    }

    public static int mazePath__tabul(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir){
        for(int sr=ER; sr>= SR; sr--){
            for(int sc = EC; sc >= SC; sc--){
                if(ER == sr && EC == sc ){
                    dp[sr][sc] = 1;
                    continue;
                }
        int count = 0;

        for(int[]d : dir){
            int r = sr + d[0];
            int c = sc + d[1];
            if(r >=0 && c >=0 && r < dp.length && c < dp[0].length ){
                count += dp[r][c];
            }
        }
            
        dp[sr][sc] = count;
    }
    }
        return dp[SR][SC];
    }

    public static int mazePathJump__tabul(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir){
        for(int sr=ER; sr>= SR; sr--){
            for(int sc = EC; sc >= SC; sc--){
                if(ER == sr && EC == sc ){
                    dp[sr][sc] = 1;
                    continue;
                }
        int count = 0;

        for(int[]d : dir){
            for(int rad=1; rad<=Math.max(ER,EC); rad++){
                int r = sr + rad * d[0];
                int c = sc + rad* d[1];
                if(r >=0 && c >=0 && r < dp.length && c < dp[0].length ){
                    count += dp[r][c];
                }
            }
        }
        dp[sr][sc] = count;
    }
    }
        return dp[SR][SC];
    }

    public static int mazePathJump__tabul__2(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir){
        for(int sr=ER; sr>= SR; sr--){
            for(int sc = EC; sc >= SC; sc--){
                if(ER == sr && EC == sc ){
                    dp[sr][sc] = 1;
                    continue;
                }
        int count = 0;

        for(int[]d : dir){
                int r = sr + d[0];
                int c = sc + d[1];
                while(r >=0 && c >=0 && r < dp.length && c < dp[0].length ){
                    count += dp[r][c];
                    r += d[0];
                    c += d[1];
                }
        }
        dp[sr][sc] = count;
    }
    }
        return dp[SR][SC];
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
        int sr = 0, sc =0, er =3, ec= 3;
        int[][] dp = new int[er+1][ec+1];
        int[][] dir = { {1,0}, {0,1}, {1,1}};

        int radius = Math.max(er,ec);

        // fibo();
        // System.out.print(mazePathJump(sr, sc, er-1, ec-1, dp, dir, radius));
        System.out.println(mazePath__tabul(sr, sc, er, ec, dp, dir));           
        display2d(dp);
    }
}
