import java.util.*;

public class DynamicInput {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        String[] data = new String[n];
        scn.nextLine();
        int counter = 0;

        while (counter++ < n) {
            data[counter-1] = scn.nextLine();
        }
        for(int i=0; i<data.length; i++)
            System.out.println(data[i].trim());
    }

}
