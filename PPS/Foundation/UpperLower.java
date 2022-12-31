import java.io.*;

public class UpperLower {
    static void upper(int matrix[][],
            int row, int col) {

        for (int gap = 0; gap < row; gap++) {
            for (int i = 0, j = gap; j < col && i< row; j++, i++) {
                System.out.println(matrix[i][j] + "");
            }
        }
    }

    static void lower(int matrix[][],
            int row, int col) {

        for (int gap = 0; gap < row; gap++) {
            for (int i = gap, j = 0; j < col && i<row; i++, j++) {
                System.out.println(matrix[i][j] + "");
            }
        }
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        int row = 3, col = 3;

        System.out.println("Lower triangular matrix: ");
        lower(matrix, row, col);

        System.out.println("Upper triangular matrix: ");
        upper(matrix, row, col);
    }
}