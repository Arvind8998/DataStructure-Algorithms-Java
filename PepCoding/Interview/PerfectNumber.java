import java.util.ArrayList;
import java.util.Scanner;

public class PerfectNumber {

    private static String getPerfectDivisors(int n) {
        String ans = "1 + ";
        int sum = 1;
        for (int i = 2; i*i <= n; i++) {
            System.out.println(n + "-----" + i);
            if (n % i == 0) {
                if (sum < n) {
                    sum += i + n/i;
                    ans += i + " + " + n/i;
                }
            }
             if (sum == n) {
                return  ans.substring(0, ans.length()).trim();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        ArrayList<Integer> l = new ArrayList<>();
        while (n != -1) {
            if (n > 2 && n < 100000) {
                n = sc.nextInt();
                l.add(n);
            }
        }

        for (int i : l) {
            if (i != -1) {
                String s = getPerfectDivisors(i);
                if (s == "") {
                    System.out.println(i + " is NOT perfect.");
                } else {
                    System.out.println(i + " = " + s);
                }
            }
        }

        sc.close();
    }
}