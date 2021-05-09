import java.io.*;
import java.util.*;

public class Main {
    
    public static Scanner scn  = new Scanner(System.in);

 public static String[] nokiaKeys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
 
    public static void main(String[] args) throws Exception {
       
        String str = scn.nextLine();
        printKPC(str,"");
    }

    public static int printKPC(String str, String ans) {
        
        if(str.length() ==0 ){
            System.out.println(ans);
            return 1;
        }
        
        char ch = str.charAt(0);
        int idx = ch - '0';
        String word = nokiaKeys[idx];
        int count = 0;
        
        for(int i=0; i<word.length(); i++)
            count += printKPC(str.substring(1), ans+ word.charAt(i));
        return count;
    }

}