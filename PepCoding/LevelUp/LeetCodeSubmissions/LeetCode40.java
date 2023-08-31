package PepCoding.LevelUp.LeetCodeSubmissions;
class Solution {
    
    public void getCombinations(List<List<Integer>> ans, List<Integer> combinations, int[] candidates, int target, int idx){
        if(target == 0){
            ans.add(new ArrayList<>(combinations));
        }
        int prev = -1;
        
        for(int i= idx; i<candidates.length; i++){
            if(prev!= candidates[i] && target - candidates[i] >=0){
                combinations.add(candidates[i]);
                getCombinations(ans, combinations, candidates, target-candidates[i], i+1);
                combinations.remove(combinations.size()-1);
            }
            prev = candidates[i];
            
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinations(ans, combinations, candidates, target, 0);
        return ans;
    }
}