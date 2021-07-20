package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    public static void display(ArrayList<Edge>[] graph, int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.nbr + ", " + e.wt + ") ");
            }
            System.out.println();
        }

    }

    public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {
        ArrayList<Edge> list = graph[u];
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);
            if (e.nbr == v)
                return i;
        }

        return -1;
    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v) {
        int i1 = findEdge(graph, u, v);
        int i2 = findEdge(graph, v, u);

        graph[u].remove(i1);
        graph[v].remove(i2);
    }

    public static void removeVtx(ArrayList<Edge>[] graph, int u) {
        ArrayList<Edge> list = graph[u];
        for (int i = list.size() - 1; i >= 0; i--) {
            Edge e = list.get(i);
            removeEdge(graph, e.src, e.nbr);
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest)
            return true;

        vis[src] = true;
        boolean res = false;
        for (Edge e : graph[src])
            if (!vis[e.nbr])
                res = res || hasPath(graph, e.nbr, dest, vis);

        return res;
    }

    public static int printAllPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String psf) {
        if (src == dest) {
            System.out.println(psf + dest);
            return 1;
        }
        int count = 0;
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr])
                count += printAllPath(graph, e.nbr, dest, vis, psf + e.src);
        }
        vis[src] = false;
        return count;
    }

    public static void preOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf) {
        System.out.println(src + " -> " + (psf + src) + " @ " + wsf);
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr])
                preOrder(graph, e.nbr, vis, wsf + e.wt, psf + src);
        }

        vis[src] = false;
    }

    public static void postOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr])
                postOrder(graph, e.nbr, vis, wsf + e.wt, psf + e.nbr);
        }

        System.out.println(src + " -> " + psf + " @ " + wsf);
        vis[src] = false;
    }

    public static class lightestPathPair {
        String psf = "";
        int wsf = (int) 1e9;
    }

    public static lightestPathPair lightestPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest) {
            lightestPathPair base = new lightestPathPair();
            base.psf += src;
            base.wsf = 0;

            return base;
        }

        vis[src] = true;
        lightestPathPair myAns = new lightestPathPair();
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                lightestPathPair recAns = lightestPath(graph, e.nbr, dest, vis);
                if (recAns.wsf != -1 && recAns.wsf + e.wt < myAns.wsf) {
                    myAns.psf = src + recAns.psf;
                    myAns.wsf = recAns.wsf + e.wt;
                }
            }
        }
        vis[src] = false;
        return myAns;
    }

    public static void lightestPath(ArrayList<Edge>[] graph, int src, int dest) {
        boolean[] vis = new boolean[graph.length];
        lightestPathPair ans = lightestPath(graph, src, dest, vis);

        System.out.println("lightest Path: " + ans.psf + " of weight: " + ans.wsf);
    }

    public static class pathPair {
        String psf = "";
        int wsf = -1;
    }

    public static pathPair heaviestPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest) {
            pathPair base = new pathPair();
            base.psf += src;
            base.wsf = 0;

            return base;
        }

        vis[src] = true;
        pathPair myAns = new pathPair();
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                pathPair recAns = heaviestPath(graph, e.nbr, dest, vis);
                if (recAns.wsf != -1 && recAns.wsf + e.wt > myAns.wsf) {
                    myAns.psf = src + recAns.psf;
                    myAns.wsf = recAns.wsf + e.wt;
                }
            }
        }
        vis[src] = false;
        return myAns;
    }

    public static void heaviestPath(ArrayList<Edge>[] graph, int src, int dest) {
        boolean[] vis = new boolean[graph.length];
        pathPair ans = heaviestPath(graph, src, dest, vis);

        System.out.println("Heaviest Path: " + ans.psf + " of weight: " + ans.wsf);
    }

    public static class ceilFloorPair {
        int ceil = (int) 1e9;
        int floor = -(int) 1e9;
    }

    public void ceilAndFloor(ArrayList<Edge>[] graph, int src, int data, boolean[] vis, int wsf, ceilFloorPair pair) {
        if (wsf > data) {
            pair.ceil = Math.min(data, pair.ceil);
        }
        if (wsf < data) {
            pair.floor = Math.max(data, pair.floor);
        }
        vis[src] = true;

        for (Edge e : graph[src]) {
            if (!vis[e.nbr])
                ceilAndFloor(graph, e.nbr, data, vis, wsf + e.wt, pair);
        }
        vis[src] = false;
    }

    public void ceilAndFloor(ArrayList<Edge>[] graph, int src, int data) {
        ceilFloorPair pair = new ceilFloorPair();
        boolean[] vis = new boolean[graph.length];
        ceilAndFloor(graph, src, data, vis, 0, pair);
    }

    public static void dfs_GCC(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                dfs_GCC(graph, e.nbr, vis);
            }

        }
    }

    public static int GCC(ArrayList<Edge>[] graph) {
        int N = graph.length, componentCount = 0;
        boolean[] vis = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfs_GCC(graph, i, vis);
                componentCount++;
            }
        }
        return componentCount;
    }

    public static void dfs_GCC(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> base) {
        base.add(src);
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                dfs_GCC(graph, e.nbr, vis, base);
            }

        }
    }

    public static void GCC(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps) {
        int N = graph.length, componentCount = 0;
        boolean[] vis = new boolean[N];

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> base = new ArrayList<>();
            if (!vis[i]) {
                dfs_GCC(graph, i, vis, base);
                componentCount++;
                comps.add(base);
            }
        }
    }

    public int dfs(int[][] grid, int sr, int sc, int[][] dir) {
        int count = 0;
        grid[sr][sc] = 0;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {

                count += dfs(grid, r, c, dir);
            }

        }
        return count + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int areaCount = 0, n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    areaCount = Math.max(areaCount, dfs(grid, i, j, dir));
            }
        }
        return areaCount;

    }

    public static void HamiltonianPath(ArrayList<Edge>[] graph, int osrc, int src, int edgeCount, String psf,
            boolean[] vis) {
        if (edgeCount == graph.length - 1) {
            int idx = findEdge(graph, src, osrc);
            if (idx != -1) {
                System.out.println(psf + src + "*");
            } else {
                System.out.println(psf + src + ".");
            }
            return;
        }
        vis[src] = true;

        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                HamiltonianPath(graph, osrc, e.nbr, edgeCount + 1, psf + e.src, vis);
            }
        }
        vis[src] = false;
    }

    public static void HamiltonianPath(ArrayList<Edge>[] graph, int src) {
        int N = graph.length;
        boolean[] vis = new boolean[N];
        HamiltonianPath(graph, src, src, 0, "", vis);
    }

    public static void BFS(ArrayList<Edge>[] graph, int src, int dest) {
        LinkedList<Integer> que = new LinkedList<>();
        int N = graph.length;
        boolean[] vis = new boolean[N];

        que.addLast(src);
        int level = 0;

        boolean isCyclePresent = false;
        int shortestPath = -1;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();

                // for cycle
                if (vis[rvtx]) {
                    isCyclePresent = true;
                    continue;
                }

                if (rvtx == dest) {
                    shortestPath = level;
                }

                vis[rvtx] = true;
                for (Edge e : graph[rvtx]) {
                    if (!vis[e.nbr]) {
                        que.addLast(e.nbr);
                    }
                }
            }
        }
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph, int src) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(src);
        int level = 0;
        boolean isCyclePresent = false;
        int N = graph.length;
        boolean[] vis = new boolean[N];

        while (queue.size() > 0) {
            int length = queue.size();
            while (length-- > 0) {
                int rvtx = queue.removeFirst();

                if (vis[rvtx]) {
                    isCyclePresent = true;
                    return isCyclePresent;
                }

                vis[rvtx] = true;
                for (Edge e : graph[rvtx]) {
                    if (!vis[e.nbr]) {
                        queue.addLast(e.nbr);
                    }
                }
            }
        }
        return isCyclePresent;
    }

    public static boolean isCyclePresent(ArrayList<Edge>[] graph, int src) {
        boolean res = false;
        for (int i = 0; i < graph.length; i++) {
            res = res || isCyclic(graph, i);
        }
        return res;
    }

    public static class BFS_Pair {
        int vrtx = 0;
        String psf = "";
        int wsf = 0;

        BFS_Pair(int vrtx, String psf, int wsf) {
            this.vrtx = vrtx;
            this.psf = psf;
            this.wsf = wsf;
        }
    }

    public static void findUniqueShortestPath(ArrayList<Edge>[] graph, int src) {
        int N = graph.length;
        boolean[] vis = new boolean[N];
        LinkedList<BFS_Pair> queue = new LinkedList<>();
        queue.addLast(new BFS_Pair(src, src + "", 0));

        while (queue.size() > 0) {
            int length = queue.size();
            while (length-- > 0) {
                BFS_Pair rp = queue.removeFirst();

                if (vis[rp.vrtx])
                    continue;

                System.out.println(rp.vrtx + "->" + rp.psf + "@" + rp.wsf);

                vis[rp.vrtx] = true;

                for (Edge e : graph[rp.vrtx]) {
                    if (!vis[e.nbr]) {
                        queue.addLast(new BFS_Pair(e.nbr, rp.psf + e.nbr, rp.wsf + e.wt));
                    }
                }
            }
        }
    }

    public static int infectionSpreadCount(ArrayList<Edge>[] graph, int src, int givendays) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(src);
        int N = graph.length;
        boolean[] vis = new boolean[N];
        int days = 1;
        int infectedCount = 0;

        while (queue.size() > 0) {
            int length = queue.size();
            if (days > givendays)
                break;

            while (length-- > 0) {
                int ip = queue.removeFirst();

                if (vis[ip])
                    continue;
                vis[ip] = true;
                infectedCount++;
                for (Edge e : graph[ip]) {
                    if (!vis[e.nbr]) {
                        queue.addLast(e.nbr);
                    }
                }
            }
            days++;
        }
        return infectedCount;
    }

    public static void construction() {
        int N = 7;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);

        boolean[] vis = new boolean[N];
        // printAllPath(graph, 0, 6, vis, "");
        // heaviestPath(graph, 0,6);
        // preOrder(graph, 0, vis, 0, "");
        // GCC(graph);
        findUniqueShortestPath(graph, 0);
    }

    public static void main(String[] args) {
        construction();
        // printAllPath();
    }
}