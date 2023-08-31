import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = -(int) 1e9;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int i = 1; i <= max; i++) {
            for (int idx = 0; idx < arr.length; idx++) {
                if (i <= arr[idx]) {
                    System.out.print("*"+ "\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

}