package PepCoding.LevelUp.Graph;
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int u = edges[0];
            int v = edges[1];

            int lu = find(parent, u);
            int lv = find(parent, v);

            if (lu != lv) {
                if (rank[lu] > rank[lv]) {
                    parent[lv] = lu;
                    rank[lu] += rank[lv];
                } else if (rank[lu] < rank[lv]) {
                    parent[lu] = lv;
                    rank[lu] += rank[lv];
                } 
                else {
                    parent[lu] = lv;
                    rank[lv]++;
                }
            } else {
                return edge;
            }

            return new int[2];
        }

    }

    public static int find(int[] parent, int n) {
        if (parent[n] == n) {
            return n;
        }
        int temp = find(parent, parent[n]);
        return temp;
    }

}