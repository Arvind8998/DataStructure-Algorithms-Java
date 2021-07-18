import java.io.*;
import java.util.*;

public class Main{
    public static Scanner scn = new Scanner(System.in);

public static void main(String[] args) throws Exception {
    // write your code here
    int n = scn.nextInt();
    
    int[] arr = new int[n];
    
    for(int i=0; i<n; i++){
        arr[i] = scn.nextInt();
    }
    
    HashMap<Integer, boolean> map = new HashMap<>();
    
    for(int i=0; i<n; i++)
        map.put(arr[i], true);
        
    for(int i=0; i<n; i++){
        if(map.containsKey(arr[i]-1))
            map.put(arr[i], false);
    }
    
    int ml = 0;
    int mel = 0;
    
    for(int i=0; i<n; i++){
        if(map.get(arr[i])){
            int tl = 0;
            int tel = arr[i];
            
            while(map.containsKey(tl + tel))
                tl++;
                
            if(tl > ml){
               ml = tl;
               mel = arr[i];
            }
        }
    }
    
    for(int i=0; i< ml; i++)
        System.out.println(mel++);
        
 }

}