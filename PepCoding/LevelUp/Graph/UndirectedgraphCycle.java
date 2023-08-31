package PepCoding.LevelUp.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

import jdk.internal.util.xml.impl.Pair;

class Solution {

    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int vtces = edges.length;
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i].add(new Edge(edges[i][0], edges[i][1]));
            graph[i].add(new Edge(edges[i][0], edges[i][1]));
        }
        
        boolean[] visited = new boolean[vtces];

        for(int i=0)
        
    }

    public static isCycle(int src, int[][] edges, boolean[] visited){
         ArrayDeque<Pair> q = new ArrayDeque<>();
            q.add(new Pair(src, src+""));

            while(q.size() > 0){
                int rem = q.removeFirst();
                if(visited[rem.v] == true){
                    return true;
                }
                for(int i=0; i<)
            }
    }

    static class pair {
        int v;
        String psf;
    }
}
