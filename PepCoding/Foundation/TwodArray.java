import java.io.*;
import java.util.*;

public class Main {
    public static Scanner = new Scanner(System.in);
    
    
    public static void input(int[][] arr){
    int n = arr.length;
    int m = arr[0].length;

    for(int i=0;i<n; i++){
        for(int j=0; j<m; j++){
            arr[i][j] = scn.nextInt();
        }
    }
}

    public static ExitMatrix(int[][] arr){
        int dir =0, i=0, j=0;
        while(true){
            if(dir == 0){ //North
                j++;
                if(j == m){
                    System.out.println(i + "\n" + (j-1));
                    break;
                }
            }
            else if(dir == 1){ //East
                i++;
                if(i == n){
                    System.out.println((i-1) + "\n" + j);
                    break;
                }
            }
            else if(dir == 2){ //South
                j--;
                if(j == -1){
                    System.out.println(i + "\n" + (j+1));
                    break;
                }
            }
            else if(dir == 3){ //West
                i--;
                if(j == m){
                    System.out.println((i+1) + "\n" + j);
                    break;
                }
            }
        }
    }
    
    
    
    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        int m = scn.nextInt();
        input(arr[n][m]);
        ExitMatrix(arr[n][m])
    }

}