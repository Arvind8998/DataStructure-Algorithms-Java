import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int idx = 0; idx < n; idx++) {
            arr[idx] = scanner.nextInt();
        }

        int max = -(int) 1e9, min = (int) 1e9;

        for (int idx = 0; idx < n; idx++) {
            max = arr[idx] > max ? arr[idx] : max;
            min = arr[idx] < min ? arr[idx] : min;
        }
        System.out.print(max - min);
    }

}