import java.util.*;
import java.io.*;

public class DirectionMaze{

    public static int getMazePath(int sr, int sc, int er, int ec, String ans, int[][] dir, String[] dirS){
        if(sr == er && sc == ec){
            System.out.println(ans);
            return 1;
        }
        int count = 0;

        for(int d=0; d<dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >=0 && c >= 0 && r <= er && c <= ec){
                count += getMazePath(r, c, er, ec, ans + dirS[d], dir, dirS);
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[][] dir = {{0,1}, {1,1}, {1,0}};
        String[] dirS = {"H", "D", "V"};
        System.out.println(getMazePath(0, 0, 2, 2,"", dir, dirS));
    }
}