import java.sql.SQLOutput;
import java.util.Scanner;

public class CreditCardInavlidToValid {
    public static Scanner scn = new Scanner(System.in);

    public static int powerFunction(int num){
        int power = 1;
        int number = num/10;
        while(number !=0){
            number /= 10;
            power *= 10;
        }
        return power;
    }

    public static int numberConvertorHelper(int num, int powerValue){
        int result = 0;
        int currIdx= 1;

        while(num !=0){
            int currLastDigit = num % 10;
            if(currIdx++ %2 != 0) {
                currLastDigit = currLastDigit * 2 >= 10 ?
                        (currLastDigit/10 + currLastDigit/10)
                        : currLastDigit;
            }

            result += currLastDigit *powerValue;
            num /= 10;
            powerValue /= 10;
        }
        return result;
    }

    public static String numberValidator(int num){

        int powerValue = powerFunction(num);
        int firstDigit = num/powerValue;
        int digitsSum = numberConvertorHelper(num, powerValue);

        if(num%10 == 0) return "VALID";
        else{
            int lastDigit = num %10;
            int closestValidNumber = firstDigit*10 + 10;

            int difference = (closestValidNumber - digitsSum);
            int newLastDigit = lastDigit+difference;
            return "INVALID "+ newLastDigit;
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter input number");
        long num= scn.nextLong();
        System.out.println("NUMBER IS" + num);
        System.out.println(numberValidator(num));
    }
}
