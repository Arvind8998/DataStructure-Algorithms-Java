import java.io.*;
	import java.util.*;

	public class Main {

        public static Scanner scn = new Scanner(System.in);
        
	    public static void main(String[] args) throws Exception {
            int n = scn.nextInt();
            int m = scn.nextInt();
            
            int[][] dir = {{0,1}, {1,0}};
            String[] dirS = {"h", "v"};
            
            printMazePaths(0,0,n-1,m-1,"",dir,dirS);
	    }

	   
	    public static int printMazePaths(int sr, int sc, int dr, int dc, String ans, int[][] dir, String[] dirS) {
            if(sr == dr && sc == dc){
                System.out.println(ans);
                return 1;
            }
            int count = 0;
            
            for(int d=0; d<dir.length; d++){
                int r = sr + dir[d][0];
                int c = sc + dir[d][1];
                
                if(r >=0 && c>=0 && r <=dr && c <= dc){
                    count += printMazePaths(r,c,dr,dc,ans+dirS[d],dir,dirS);
                }
                
            }
            return count;
	    }

	}