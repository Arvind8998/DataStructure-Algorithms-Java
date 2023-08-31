import java.util.*;
  
  public class Main{
  
    public static int countDigits(int n){
        int count = 0;
        while(n !=0){
            n /= 10;
            count ++;
        }
        return count;

    }
  public static void main(String[] args) {
    // write your code here  
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

   int numOfDigits =  countDigits(n);
   System.out.println(numOfDigits);
   }
  }