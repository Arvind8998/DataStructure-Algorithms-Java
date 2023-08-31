import java.util.Scanner;

public class DigitsOfNumber{
    public static Scanner scn = new Scanner(System.in);

    public static int getDigitsCount(int n){
        int len = 0;
        while(n !=0){
            n /= 10;
            len ++;
        }
        return len;
    }

    public static int getPowerEqualDigit(int n){
        int pow = 1;
        int temp = n;
        n /= 10;    
        while(n !=0){
            pow *=10;
            n /= 10;
        }
        return pow;
    }

    public static void printDigitsOfANumber(int n){
        int noOfDigits = getDigitsCount(n);

        int divisor = getPowerEqualDigit(n);

        
        while(n !=0){
            int quotient = n / divisor;
            System.out.println(quotient );
             n = n % divisor;
            divisor /= 10;
        }
    }

    public static void main(String[] args){
        int n = scn.nextInt();
        printDigitsOfANumber(n);
    }
}