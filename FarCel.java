import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int far = scn.nextInt();
        
        float cel = (float)((far -32)*5)/9;
        System.out.println(cel);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}