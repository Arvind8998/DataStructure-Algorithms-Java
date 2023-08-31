package PepCoding.LevelUp.Recursion;
public class InterviewBitRecursion {

    public static void getCombinationSubsets(ArrayList<ArrayList<Integer>> ans, 
    ArrayList<Integer> subsets, ArrayList<Integer> arr, int idx){
    ans.add(new ArrayList<>(subsets));
    for(int i=idx; i< arr.size(); i++){
        subsets.add(arr.get(i));
            getCombinationSubsets(ans, subsets, arr,  i+1);
            subsets.remove(subsets.size()-1);
        }
    }
    
        public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> subsets = new ArrayList<>();
            getCombinationSubsets(ans, subsets, A, 0);
            return ans;
        }
    }
    