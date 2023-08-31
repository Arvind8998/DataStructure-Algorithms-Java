import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

int ans = findCelebrity(arr);
        System.out.println( ans == -1 ? "none" : ans);

    }

    public static int findCelebrity(int[][] arr) {
        int celebrity = 0, n= arr.length;
        for(int i=0; i<n; i++){
            if(celebrity != i && arr[celebrity][i] == 1 ){
                celebrity = i;
            }
        }
        
        for(int i=0; i<n; i++){
            if(celebrity == i ) continue;
            if( (arr[celebrity][i] == 1) || ( arr[i][celebrity] == 0) ){
                return -1;
            }
        }
        return celebrity;
    }

}