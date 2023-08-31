class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int val = 1;

        for (int j = 0; j <= rowIndex; j++) {
            res.add(val);
            val = (int) (((long)val * (rowIndex - j)) / (j + 1));

        }
        return res;
    }
}