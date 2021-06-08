import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
       LinkedList<int []> st = new LinkedList<>();
       Arrays.sort(arr, (a,b) -> {
          return a[0] - b[0];
       });
       for(int[] a :arr){
           int minStartTime = a[0];
           int maxStartTime = a[1];
           while( st.size() != 0 && a[0] <= st.getFirst()[1]){
               minStartTime = st.getFirst()[0];
               maxStartTime = Math.max( maxStartTime, st.getFirst()[1] );
               st.removeFirst();
           }
           st.addFirst(new int[] {minStartTime, maxStartTime });
       }
       
       while(st.size() != 0){
           int []a = st.removeLast();
           System.out.println(a[0] + " " + a[1]);
       }
    }

}