import java.util.*;

public class KPartitions {
static int count = 0;
	public static void solution(int i, int n, int k, int ssf, ArrayList<ArrayList<Integer>> ans) {
        if(i == n){
            count ++;
            System.out.print(count + '.');

            for(ArrayList<Integer> el : ans){
                System.out.print(el);
            }
            return;
        }
		for(int j=0; j<k; j++){
            ArrayList<Integer> set = ans.get(i);
            int setCounter = set.size() > 0 ? 0 : 1;
            set.add(i);
            solution(i+1, n, k, ssf + setCounter, ans);
            set.remove(set.size() -1);
        }
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);

	}

}