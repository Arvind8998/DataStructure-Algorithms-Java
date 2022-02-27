class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int si = 0, ei = people.length - 1, boatCount = 0;
        while (ei >= si) {
            if (people[si] + people[ei] <= limit) {
                si++;
                ei--;
                boatCount++;
            } else {
                ei--;
                boatCount++;
            }
        }
        return boatCount;
    }
}