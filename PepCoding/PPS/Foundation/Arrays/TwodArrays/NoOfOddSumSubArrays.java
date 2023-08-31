import java.util.*;

public class NoOfOddSumSubArrays {

    public int numOfSubarrays(int[] arr) {
        int even = 0, odd = 0, sum = 0;
        long ans = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even + 1;
                odd++;
            }

        }
        return (int) (ans % (1e9 + 7));
    }

}
