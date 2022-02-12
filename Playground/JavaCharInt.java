import java.util.ArrayList;
import java.util.List;

public class JavaCharInt {

    public static void permute(int[] nums, int count, List<List<Integer>> res, List<Integer> ans) {

        if (count == 3) {
            List<Integer> base = new ArrayList<>(ans);
            res.add(base);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= -10 && nums[i] <= 100) {
                int val = nums[i];

                nums[i] = -11;
                ans.add(val);

                permute(nums, count + 1, res, ans);

                ans.remove(ans.size() - 1);
                nums[i] = val;
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] nums = new int[] {2,4,8,12,16,11};

        permute(nums, 0, res, ans);
        System.out.print(res);
    }

    
}
