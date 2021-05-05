import java.util.*;

public class MazePath{

    public static Scanner scn = new Scanner(System.in);
    
    public static ArrayList<String> getMazePath(int sr, int sc, int er, int ec, String ans, int[][] dir, String[] dirS){
      if(sr == er && sc == ec){
          ArrayList<String> outAns = new ArrayList<>();
          outAns.add(ans);
          return outAns;
      }
      ArrayList<String> output = new ArrayList<>();

        for(int d=0; d<dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r >=0 && c>=0 && r <= er && c <= ec){
              ArrayList<String> myAns =  getMazePath(r, c, er, ec, ans+dirS[d], dir, dirS);
              for(String st: myAns){ 
                output.add(st);
              }
            }
        }
        return output;
    }
    
    public static void main(String[] args){
        int[][] dir = {{0,1}, {1,0}};
        String[] dirS = {"h", "v"};
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(getMazePath(0, 0, n-1, m-1,"", dir, dirS));
    }
}