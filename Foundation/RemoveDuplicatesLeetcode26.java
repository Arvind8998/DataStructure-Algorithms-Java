import java.util.ArrayList;

class RemoveDuplicatesLeetcode26 {

    public static int removeDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        int index = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                list.add(nums[i + 1]);
                nums[index++] = nums[i + 1];
            }
        }
        for (int a : list)
            System.out.println(a);
        return index;
    }

    public static void main(String[] args) {
        int[] data = { 1, 1, 22, 22, 67, 79, 79 };
        removeDuplicates(data);
    }
}