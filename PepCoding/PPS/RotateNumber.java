import java.util.*;

public class Main {

  public static int rotateNumber(int noOfDigits, int n, int k) {
    int mul = 1, div = 1;
    for (int i = 1; i <= noOfDigits; i++) {
      if (i <= k) {
        div *= 10;
      } else {
        mul *= 10;
      }
    }
    int quo = n / div;
    int rem = n % div;
    int rotatedNum = rem * mul + quo;
    return rotatedNum;
  }

  public static int countNoOfDigits(int n) {
    int count = 0;
    while (n != 0) {
      count++;
      n /= 10;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();

    int noOfDigits = countNoOfDigits(n);
    k = k % noOfDigits;

    if (k < 0) {
      k += noOfDigits;
    }
    int rotatedNumber = rotateNumber(noOfDigits, n, k);
    System.out.println(rotatedNumber);
  }
}