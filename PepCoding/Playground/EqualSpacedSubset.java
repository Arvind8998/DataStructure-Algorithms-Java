import java.util.ArrayList;
import java.util.Scanner;

public class EqualSpacedSubset {

    public static Scanner scn = new Scanner(System.in);

    private static boolean search(int[] arr, int ele) {
        for (int e : arr) {
            if (e == ele) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int n = scn.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }

        int maxEle = -(int) 1e9;

        for (int j = 0; j < nums.length; j++) {
            maxEle = Math.max(maxEle, nums[j]);
        }

        int k = maxEle / 2 - 1;
        // System.out.print("---------" + "Printing");
            for (int p = 0; p < nums.length; p++) {
                for (int space = 1; space <= k; space++) {
                int trip = 1;
                int curr = nums[p];
                // System.out.println("Printing Curr" + curr);
                if (search(nums, curr - space)) {
                    trip++;
                }
                if (search(nums, curr + space)) {
                    trip++;
                }
                if (trip == 3) {
                    System.out.println((curr - space) + " " + curr + " " + (curr + space));
                    trip = 1;
                }
            }
        }
    }
}
