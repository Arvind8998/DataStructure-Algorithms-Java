import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        int m = scn.nextInt();
        int maxRadius = Math.max(n,m);
        int[][] dir = {{0,1},{1,0},{1,1}};
        String[] dirS = {"h","v","d"};
        
        System.out.println(getMazePaths(0,0,"",n-1,m-1, dir, dirS,maxRadius));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, String ans, int dr, int dc, int[][] dir, String[] dirS, int maxRadius) {
        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add(ans);
            return base;
        }
        
        int count = 0;
        ArrayList<String> myAns = new ArrayList<>();
        
        for(int d=0; d<dir.length; d++){
            
            
                
                for(int radius=1; radius<maxRadius; radius++){
            int r = sr + dir[d][0]*radius;
            int c = sc + dir[d][1]*radius;
            if(r >=0 && c >=0 && r <=dr && c <= dc){
                 ArrayLi
