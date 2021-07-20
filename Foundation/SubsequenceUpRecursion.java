import java.io.*;
import java.util.*;

public class SubsequenceUpRecursion {

public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
     String str = scn.nextLine();
     printSS(str,"");
    }

    public static void printSS(String str, String ans) {
       if(str.length() == 0){
           System.out.println(ans);
           return;
       }
       
       char ch = str.charAt(0);
       String roq = str.substring(1);
       
        printSS(roq, ans+ch);
       printSS(roq, ans);
      
        
    }

}