class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();  
        ArrayList<Integer> intersected = new ArrayList<>();
        
        for(int el: nums1)
            map.put(el, map.getOrDefault(el, 0) +1);
        
        for(int el: nums2){
            if(map.containsKey(el)){
                intersected.add(el);
                map.remove(el);
            }
        }
        
        int[] ans = new int[intersected.size()];
        int idx =0;
        
        for(int el : intersected)
            ans[idx++] = el;
        
        return ans;
    }
}