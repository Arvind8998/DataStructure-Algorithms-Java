import java.util.ArrayList;

class Solution {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public boolean hasPath(ArrayList<Edge>[] graph, int N, int[][] edges, int source, int destination, boolean[] vis) {
        if (source == destination)
            return true;
        vis[source] = true;
        boolean res = false;

        for(Edge e: graph[source]){
            if (!vis[e.nbr]) {
                res = res || hasPath(graph, N, edges, e.nbr, destination, vis);
            }
        }
        return res;
    }

    public void addEdge(ArrayList<Edge>[] graph, int u, int v) {
        graph[u].add(new Edge(u, v));
        graph[v].add(new Edge(v, u));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];
        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

            for (int i = 0; i < edges.length; i++) {
                addEdge(graph, edges[i][0], edges[i][1]);
                addEdge(graph, edges[i][1], edges[i][0]);
            }

        return hasPath(graph, n, edges, source, destination, vis);
    }
}