import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] getModifiedArray(int length, int[][] queries) {
        int[] arr = new int[length];

        for (int i = 0; i < queries.length; i++) {
            int st = queries[i][0];
            int et = queries[i][1];
            int inc = queries[i][2];

            arr[st] += inc;
            if (et + 1 < length) {
                arr[et + 1] -= inc;
            }

        }

        // Making prefix array
        int sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            arr[j] = sum;
        }

        return arr;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int length = scn.nextInt();

        int nq = scn.nextInt();

        int[][] queries = new int[nq][3];

        for (int q = 0; q < nq; q++) {
            queries[q][0] = scn.nextInt();
            queries[q][1] = scn.nextInt();
            queries[q][2] = scn.nextInt();
        }

        int[] res = getModifiedArray(length, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}