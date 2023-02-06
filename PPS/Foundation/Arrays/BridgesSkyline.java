import java.util.*;

public class BridgesSkyline {

    public static Scanner scanner = new Scanner(System.in);

    public static void inputTwoDimArray(int[][] arr) {
        int n = arr.length; 
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
                // System.out.print(arr[i][j] + " ");
            }
            // System.out.println();
        }
    }

    public static int getCurrBridgeFormationSum(int row, int col, int[][] arr) {

        int sum = 0, maxRow = row + 2;

        // first pillar
        for (int i = row; i <= maxRow; i++) {
            sum += arr[i][col];
        }

        // second pillar
        for (int i = row; i <= maxRow; i++) {
            sum += arr[i][col + 2];
        }

        // middleCell
        int midVal = arr[row + 1][col + 1];
        sum += midVal;
        return sum;
    }

    public static int[] getMaxBridgeSum(int[][] arr) {
        int maxBridgeSum = 0, currSum = 0, n = arr.length, m = arr[0].length, maxI = -1, maxJ = -1;
        for (int i = 0; i < n; i++) {
            if (i + 2 < n) {
                for (int j = 0; j < m; j++) {

                    if (j + 2 < m) {
                        currSum = getCurrBridgeFormationSum(i, j, arr);
                        // System.out.println(currSum + " " + i + " " + j + " " + maxBridgeSum);
                        if (currSum >= maxBridgeSum) {
                            maxBridgeSum = currSum;
                            maxI = i;
                            maxJ = j;
                        }
                    }
                }
            }
        }
        return new int[] { maxI, maxJ };
    }

    public static void printBridgesIndex(int[] idx) {
        int sum = 0, row = idx[0], col = idx[1], maxRow = idx[0] + 2;

        // first pillar
        for (int i = row; i <= maxRow; i++) {
            System.out.print(i + "" + col + " ");
        }

        // second pillar
        for (int i = row; i <= maxRow; i++) {
            System.out.print(i + "" + (col + 2) + " ");
        }

        // middleCell
        System.out.print(row + 1 + "" + (col + 1) + " ");
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] arr = new int[n][m];
        inputTwoDimArray(arr);

        int[] maxIdx = getMaxBridgeSum(arr);
        printBridgesIndex(maxIdx);
        // System.out.println(maxIdx[0] + " " + maxIdx[1]);
    }
}
