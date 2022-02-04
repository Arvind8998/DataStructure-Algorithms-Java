
class Solution {

    public void hasPath(int[][] graph, int src, int dest, List<List<Integer>> ans, List<Integer> path, boolean[] vis) {
        if (src == dest) {
            ans.add(new ArrayList<>(path));
        }

        vis[src] = true;
        boolean res = false;

        for (int nbr : graph[src]) {
            if (!vis[nbr]) {
                path.add(nbr);
                hasPath(graph, nbr, dest, ans, path, vis);
                path.remove(path.size() - 1);
            }
        }
        vis[src] = false;

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        boolean[] vis = new boolean[N];
        path.add(0);

        hasPath(graph, 0, N - 1, ans, path, vis);
        return ans;
    }
}