import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public class Pair implements Comparable<Pair> {
        int value;
        int gap;

        Pair(int value, int gap) {
            this.value = value;
            this.gap = gap;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.gap == p.gap) {
                return this.value - p.value;
            } else {
                return this.gap - p.gap;
            }
        }

    }

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
        return b.gap - a.gap;
    });

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Arrays.sort(arr);

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.add(new Pair(arr[i], Math.abs(x - arr[i])));
            } else {
                if (pq.peek().gap > Math.abs(arr[i] - x)) {
                    pq.remove();
                    pq.add(new Pair(arr[i], Math.abs(x - arr[i])));
                }
            }
        }

        while (pq.size() > 0) {
            res.add(pq.remove().value);
        }
        Collections.sort(res);
        return res;
    }
}