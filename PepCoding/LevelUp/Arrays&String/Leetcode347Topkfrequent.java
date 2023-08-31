import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int el : nums) {
            if (freqMap.containsKey(el)) {
                freqMap.put(el, freqMap.get(el) + 1);
            } else {
                freqMap.put(el, 1);
            }
        }
        PriorityQueue<Integer> dataQueue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        int[] ans = new int[k];

        for (int i = 0; i < nums.length; i++) {
            dataQueue.add(nums[i]);
            if (dataQueue.size() > k) {
                dataQueue.poll();
            }
        }

        int idx = 0;

        while (!dataQueue.isEmpty()) {
            ans[idx++] = dataQueue.poll();
        }

        return ans;
    }

}