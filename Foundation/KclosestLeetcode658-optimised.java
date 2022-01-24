Some test cases are failing on leetcode portal on using si<ei condition in binary search however some fails on using si< ei condition on leet code portal 

https://leetcode.com/problems/find-k-closest-elements/


Same code is working on pepcoding portal.
https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/searching-and-sorting/find_k_closest_elements/ojquestion

can someone please help with the issue here!!


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int si = 0;
        int ei = arr.length - 1;
        int mid = 0;

        while (si <= ei) {
            mid = (si + ei) / 2;
            if (arr[mid] == x) {
                break;
            } else if (arr[mid] < x) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        int left = mid - 1;
        int right = mid;
        List<Integer> res = new ArrayList<>();

        while (left >= 0 && right < arr.length && k > 0) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                res.add(arr[left]);
                left--;
            } else {
                res.add(arr[right]);
                right++;
            }
            k--;
        }

        while (left >= 0 && k > 0) {
            res.add(arr[left]);
            left--;
            k--;
        }

        while (right < arr.length && k > 0) {
            res.add(arr[right]);
            right++;
            k--;
        }

        Collections.sort(res);
        return res;

    }
}