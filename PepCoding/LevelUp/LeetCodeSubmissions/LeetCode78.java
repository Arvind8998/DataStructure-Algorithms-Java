package PepCoding.LevelUp.LeetCodeSubmissions;
class Solution {
    public void getSubsetCombinations(List<List<Integer>> ans, ArrayList<Integer> subset, int[] nums, int idx){
        ans.add(new ArrayList<>(subset));
        
        for(int i=idx; i<nums.length; i++){
            subset.add(nums[i]);
            getSubsetCombinations(ans, subset, nums, i+1);
            subset.remove(subset.size()-1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        getSubsetCombinations(ans, subset, nums, 0);
        return ans;
    }
}