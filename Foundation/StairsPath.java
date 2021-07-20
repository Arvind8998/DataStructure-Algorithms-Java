import java.util.*;
import java.io.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static ArrayList<String> getStairsPath(int n){
        if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        for(int i=1; i<=3 && n-i >=0; i++){
            ArrayList<String> recAns = getStairsPath(n-i);
            for(String s: recAns){
                myAns.add(i + s);
            }
        }
        return myAns;
    }
    public static void main(String[] args){
        int n = scn.nextInt();
        System.out.println(getStairsPath(n));
    }
}
