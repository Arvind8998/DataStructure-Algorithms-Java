import java.io.*;
import java.util.*;

public class Main {

    public static int[] getSumOfArrays(int[] arr1, int[] arr2, int n1, int n2) {
        int carry = 0;

        int len = Math.max(n1, n2) + 1;
        int[] ans = new int[len];

        int i = n1 - 1, j = n2 - 1, k = len - 1;

        while (k >= 0) {
            int sum = (i >= 0 ? arr1[i] : 0) + (j >= 0 ? arr2[j] : 0) + carry;

            carry = sum / 10;
            ans[k] = sum % 10;

            i--;
            j--;
            k--;
        }
        return ans;
    }

    public static void display1dArr(int[] sumArr) {
        for (int i = 0; i < sumArr.length; i++) {
            if (i == 0 && sumArr[i] == 0)
                continue;
            else
                System.out.print(sumArr[i]+"\n");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }

        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[] sumArr = getSumOfArrays(arr1, arr2, n1, n2);
        display1dArr(sumArr);
    }

}