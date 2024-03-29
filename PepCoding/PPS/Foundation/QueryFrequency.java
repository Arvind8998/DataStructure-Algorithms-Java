import java.util.*;

public class QueryFrequency {
    public static Scanner scanner = new Scanner(System.in);

    public static void digitFreq(long n, int[] query) {
        int[] freq = new int[10];

        while (n != 0) {
            long d = n % 10;
            n /= 10;

            freq[(int) d]++;
        }

        for (int q : query) {
            System.out.println(freq[q]);
        }
    }

    public static void main(String[] args) {
        long n = scanner.nextLong();
        int[] query = new int[(scanner.nextInt())];

        for (int i = 0; i < query.length; i++) {
            query[i] = scanner.nextInt();
        }
        digitFreq(n, query);
    }

}
