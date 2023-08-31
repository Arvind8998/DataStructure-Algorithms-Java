import java.util.PriorityQueue;
import java.util.Scanner;

public class heap {

    public static Scanner scn = new Scanner(System.in);

    public static void Int_minPQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default min Priority Queue
        for (int i = 10; i >= 1; i--)
            pq.add(i * 10);

        while (pq.size() != 0)
            System.out.println(pq.remove());
    }

    public static void Int_maxPQ() {
        // this - other, default behaviour.
        // other - this, reverse of default behaviour.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int i = 10; i >= 1; i--)
            pq.add(i * 10);

        while (pq.size() != 0)
            System.out.println(pq.remove());
    }

    public static void matrixPQ() {
        int[][] arr = { { 2, 6, 11, 3 }, { 8, 5, 16, 4 }, { 9, 7, 11, 13 }, { 8, 3, 12, 11 } };
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        for (int[] a : arr)
            pq.add(a);

        while (pq.size() != 0) {
            int[] a = pq.remove();
            for (int ele : a)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    public static class mobilePhone {
        String Company = "";
        String Model = "";
        int Ram = 0;
        int Storage = 0;
        int BatteryBackup = 0;

        mobilePhone(String Company, String Model, int Ram, int Storage, int BatteryBackup) {
            this.Company = Company;
            this.Model = Model;
            this.Ram = Ram;
            this.Storage = Storage;
            this.BatteryBackup = BatteryBackup;
        }

        mobilePhone() {

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append("Company: " + this.Company + "\n");
            sb.append("Model: " + this.Model + "\n");
            sb.append("Ram: " + this.Ram + "GB\n");
            sb.append("Storage: " + this.Storage + "GB\n");
            sb.append("BatteryBackup: " + this.BatteryBackup + "mAH\n");

            return sb.toString();
        }
    }

    public static void mobilePhoneDetails() {
        int n = scn.nextInt();

        PriorityQueue<mobilePhone> pq = new PriorityQueue<>((a, b) -> {
            if (a.Ram != b.Ram)
                return b.Ram - a.Ram;
            else if (a.Storage != b.Storage)
                return b.Storage - a.Storage;
            else
                return b.BatteryBackup - a.BatteryBackup;
        });

        for (int i = 0; i < n; i++) {
            pq.add(new mobilePhone(scn.next(), scn.next(), scn.nextInt(), scn.nextInt(), scn.nextInt()));
        }

        while (pq.size() != 0)
            System.out.println(pq.remove());
    }

    // nlog(n) -->  Brute Force
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        // Your code here
        int kthsmallest = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        for (int j = 0; j < k; j++) {
            kthsmallest = pq.remove();
        }
        return kthsmallest;
    }

    public static void kLargest(int n,int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        LinkedList<Integer> stack = new LinkedList<>();
        
        for(int i=0; i<arr.length; i++){
            if(i < k)
               pq.add(arr[i]);
            else{
                if(arr[i] > pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        
        while(pq.size() >0)
           stack.addFirst(pq.remove());
           
       while(stack.size() >0)
          System.out.print(stack.removeFirst() + " ");
   }

    public static void main(String[] args) {
        // Int_minPQ();
        // Int_maxPQ();
        // mobilePhoneDetails();
        matrixPQ();
    }
}
