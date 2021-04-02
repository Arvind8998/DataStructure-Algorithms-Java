import java.util.*;

public class Main {
    
    public static void printNoTable(int n){
        for(int i=1; i<=10; i++){
            System.out.println(n + " * " + i +" = "+ n*i);
        }
    }
    
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
       int n = scn.nextInt();
        printNoTable(n);
    }
}