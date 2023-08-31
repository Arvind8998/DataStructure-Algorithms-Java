package PepCoding.LevelUp.Recursion;
import java.util.*;

public class Main {
  
   public static boolean isValidHorizontalPlace(int i, int j, String word, char[][] arr){
        if(j-1 >=0 && arr[i][j-1] != '+')
            return false;
        else if(j+word.length() < arr[0].length && arr[i][j+word.length()] != '+')      
        return false;

        for(int jj=0; jj< word.length(); jj++){
            if(j + jj >= arr[0].length) return false;

            if(arr[i][j+ jj] == '-' || arr[i][j+ jj] == word.charAt(jj))
                continue;
            else 
                return false;
        
        }
        return true;
    }

    public static boolean isValidVerticalPlace(int i, int j, String word, char[][] arr){
        if(i-1 >=0 && arr[i-1][j] != '+') 
            return false;
        else if( i+word.length() < arr.length && arr[i+word.length()][j] != '+')
            return false;

        for(int ii=0; ii< word.length(); ii++){
            if(i + ii >= arr.length) return false;

            if(arr[i + ii][j] == '-' || arr[i+ii][j] == word.charAt(ii))
                continue;
            else 
                return false;
        
        }
        return true;
    }

    public static boolean[] placeHorizontally(int i, int j, String word, char[][] arr){
        boolean[] placedCells = new boolean[word.length()];
        
        for(int jj=0; jj<word.length(); jj++){
            if(arr[i][j+ jj] == '-'){
                placedCells[jj] = true;
                arr[i][j + jj] = word.charAt(jj);
            }
        }
        return placedCells;
    }

    public static boolean[] placeVertically(int i, int j, String word, char[][] arr){
        boolean[] placedCells = new boolean[word.length()];
        for(int ii=0; ii<word.length(); ii++){
            if(arr[i+ ii][j] == '-'){
                placedCells[ii] = true;
                arr[i+ ii][j] = word.charAt(ii);
            }
        }
        return placedCells;
    }

    public static void unPlaceHorizontally(int i, int j, boolean[] placedCells, String word, char[][] arr){
        for(int jj=0; jj< placedCells.length; jj++){
            if(placedCells[jj])
                arr[i][j+ jj] = '-';
            
        }
    }
    
    public static void unPlaceVertically( int i, int j, boolean[] placedCells, String word, char[][] arr){
        for(int ii=0; ii< placedCells.length; ii++){
            if(placedCells[ii])
                arr[i+ ii][j] = '-';
        }
    }
  
  public static void crossWord(char[][] arr, String[] words, int idx) {
        if (idx == words.length) {
            print(arr);
            return;
        }
        
        String word = words[idx];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {

                    if (isValidHorizontalPlace(i, j, word, arr)) {
                        boolean[] hPlacedCells = placeHorizontally(i, j, word, arr);
                        crossWord(arr, words, idx +1);
                        unPlaceHorizontally(i, j, hPlacedCells, word, arr);
                    }

                    if(isValidVerticalPlace(i, j, word, arr)){
                        boolean[] vPlacedCells = placeVertically(i, j, word, arr);
                        crossWord(arr, words, idx +1);
                        unPlaceVertically(i, j, vPlacedCells, word, arr);
                    }
                }
            }
        }
    }


  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    crossWord(arr, words, 0);
  }
}