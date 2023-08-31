package PepCoding.LevelUp.LeetCodeSubmissions;
class Solution {
    public void getCombinations(List<List<Integer>> ans, List<Integer> combinations, int k, int target, int idx){
        if(target == 0 && combinations.size() == k){
            ans.add(new ArrayList<>(combinations));
            return;
        }
        
        for(int i=idx; i<=9; i++){
            if(target-i >= 0){
                combinations.add(i);
                getCombinations(ans, combinations, k, target-i, i+1);
                combinations.remove(combinations.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();
        getCombinations(ans, combinations, k, n, 1);
        return ans;
    }
}