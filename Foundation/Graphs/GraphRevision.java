import java.util.ArrayList;

public class GraphRevision {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.wt = wt;
            this.nbr = nbr;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v) {
        graph[u].add(new Edge(u, v, 1));
        graph[v].add(new Edge(v, u, 1));
    }

    public static void display(ArrayList<Edge>[] graph, int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");

            for (Edge e : graph[i]) {
                System.out.print("(" + e.src + ", " + e.nbr + ", "  + e.wt + ") ");
            }
            System.out.println();
        }

    }

    // public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {
    //     ArrayList<Edge> list = graph[u];

    //     for(Edge e : list){
    //         e.nbr == v return 
    //     }
    //     return 1;
    // }

    // public static void removeEdge(int u, int v) {

    // }

    // public static void removeVtx(int u) {

    // }

    public static void graphConstruction() {
        int N = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        // int source = 0, destination = 2;

        ArrayList<Edge>[] graph = new ArrayList[N];
        
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            addEdge(graph, edges[i][0], edges[i][1]);
            addEdge(graph, edges[i][1], edges[i][0]);
        }

        display(graph, N);

    }

    public static void main(String[] args) {
        graphConstruction();
    }
}
