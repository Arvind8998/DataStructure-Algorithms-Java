import java.util.*;
  
  public class Main{
    public static void getBemjaminBulbs(int n){
        for(int i=1; i*i<=n; i++){
            System.out.println(i*i);
        }
    }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner (System.in);
    int n = scanner.nextInt();

     getBemjaminBulbs(n);

   }
  }