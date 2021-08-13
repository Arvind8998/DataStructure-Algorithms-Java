import java.util.ArrayList;
import java.util.List;
class Solution {
    
    public void getCombinations(List<List<Integer>> ans, List<Integer> combinations, int[] candidates, int target, int idx){
        if(target == 0){
            ans.add(new ArrayList<>(combinations));
        }
        for(int i= idx; i<candidates.length; i++){
            if(target - candidates[i] >=0){
                combinations.add(candidates[i]);
                getCombinations(ans, combinations, candidates, target-candidates[i], i);
                combinations.remove(combinations.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();
        getCombinations(ans, combinations, candidates, target, 0);
        return ans;
    }
}