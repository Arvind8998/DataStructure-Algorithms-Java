public class Dp{
    public static void display(int[] dp){
        for(int a : dp){
            System.out.print(a);
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

    public static void main(String[] args){
        fibo();
    }
}
