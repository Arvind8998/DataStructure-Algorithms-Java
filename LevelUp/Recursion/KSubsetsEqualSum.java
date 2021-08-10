import java.util.*;

public class Main {

	public static void ksubsets(int[] arr, int idx, int[] subsetSum, ArrayList<ArrayList<Integer>> ans) {
        if(idx == arr.length){
            int sum = subsetSum[0];
            for(int ele: subsetSum){
                if(ele != sum) return;
            }

            for(ArrayList<Integer> a : ans){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

		for(int k= 0; k< subsetSum.length; k++){
            ArrayList<Integer> set = ans.get(k);
            set.add(arr[idx]);
            subsetSum[k] += arr[idx];

            ksubsets(arr, idx+1, subsetSum, ans);

            set.remove(set.size()-1);
            subsetSum[k] -= arr[idx];
            if(set.size() == 0) break;
            // element was leader of set in which it was added, else give chance to that element to be added in other sets
        }

	}
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
        ksubsets(arr, 0, subsetSum, ans);
	}
	
	

}