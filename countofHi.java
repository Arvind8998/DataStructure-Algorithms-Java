import java.util.*;
import java.io.*;

public class countofHi{

    public static Scanner scn = new Scanner(System.in);

    public static int countofHi(String str) {
        int n = str.length();
        int i=0, count=0;
        while( i < n-1){
            if(str.charAt(i) == 'h' && str.charAt(i+1) == 'i'){
                if(i+2<n && str.charAt(i+2) == 't'){
                    i += 3;
                }
                else{
                    count++;
                    i += 2;
                }
            }
            else{
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        String str = scn.nextLine();
        System.out.print(countofHi(str));
    }
}


