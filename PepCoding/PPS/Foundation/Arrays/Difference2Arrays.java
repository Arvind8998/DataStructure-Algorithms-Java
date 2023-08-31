import java.io.*;
import java.util.*;

public class Main {

    public static int[] getDifferenceof2Arrays(int[] arr1, int[] arr2, int n1, int n2) {
        int[] ans = new int[n2];
        int i = n1 - 1, j = n2 - 1, k = ans.length - 1, borrow = 0;

        while (k >= 0) {
            int a1Val = i >= 0 ? arr1[i] : 0;

            if (arr2[j] + borrow >= a1Val) {
                ans[k] = arr2[j] + borrow - a1Val;
                borrow = 0;
            } else {
                ans[k] = arr2[j] + borrow + 10 - a1Val;
                borrow = -1;
            }
            i--;
            j--;
            k--;
        }
        return ans;
    }

    public static void display1dDiffArr(int[] diff) {
        int idx = 0;
        while (idx < diff.length) {
            if (diff[idx] == 0) {
                idx++;
            } else {
                break;
            }
        }

        while (idx < diff.length) {
            System.out.print(diff[idx] + "\n");
            idx++;
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

        int[] diff = getDifferenceof2Arrays(arr1, arr2, n1, n2);
        display1dDiffArr(diff);
    }

}