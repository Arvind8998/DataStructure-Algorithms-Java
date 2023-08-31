import java.io.*;
import java.util.*;

public class Main {
    
    public static Scanner scn = new Scanner(System.in);


    public static ArrayList<String> getSubsequence(String str) {
        
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }   
        
        char ch = str.charAt(0);
        
        
        ArrayList<String> recAns = getSubsequence(str.substring(1));
        
        ArrayList<String> myAns = new ArrayList<>();
        
            for(String s: recAns){
                myAns.add(s);
            }

            for(String s: recAns){
                myAns.add(ch +s);
            }
        
        return myAns;
    }

    public static void main(String[] args) throws Exception {
        String str = scn.nextLine();
        System.out.println(getSubsequence(str));
    }
}