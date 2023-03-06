import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static int getMinCoinChangeAmountWays(int[] data, int[] dp, int amount) {
        for (int i = 0; i < data.length; i++) {
            for (int j = data[i]; j < dp.length; j++) {
                dp[j] += dp[j - data[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        int amount = scanner.nextInt();
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        System.out.println(getMinCoinChangeAmountWays(data, dp, amount));
    }
}