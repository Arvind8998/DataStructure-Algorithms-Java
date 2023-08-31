import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner scn = new Scanner(System.in);

    public static void printStringWithoutDuplicate(String str){
        String ans = "";
        int n = str.length();
        String prev = "$";
        for(int i=0; i<n; i++){
            if(!prev. equals(str.substring(i,i+1))){
                ans += str.substring(i,i+1);
                prev = str.substring(i,i+1); 
            }
        }
                System.out.println(ans);
    }
    public static void main(String[] args) {
        String str = scn.nextLine();
        printStringWithoutDuplicate(str);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}