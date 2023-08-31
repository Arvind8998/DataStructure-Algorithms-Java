package PepCoding.LevelUp.LeetCodeSubmissions;
class Solution {
    public void getCombinations(List<List<Integer>> ans, List<Integer> combinations, int n, int k, int idx){
        if(combinations.size() ==k){
            ans.add(new ArrayList<>(combinations));
            return;
        }
        
        for(int i=idx; i<=n; i++){
            combinations.add(i);
            getCombinations(ans, combinations, n, k, i+1);
            combinations.remove(combinations.size()-1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();
        getCombinations(ans, combinations, n, k, 1);
        return ans;
    }
}