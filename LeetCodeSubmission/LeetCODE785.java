class Solution {
    
    public boolean isGraphBipartite(int[][] graph, int src, int[] vis){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(src);
        int color = 0;
        boolean cycle = false, isBipartite = true;

        while(queue.size() >0){
            int size = queue.size();
            while(size -- >0){
                int rvrtx = queue.removeFirst();

                if(vis[rvrtx] != -1){
                    cycle = true;
                    if(color != vis[rvrtx]) {
                        isBipartite = false;
                        return false;
                    }
                    continue;
                }

                vis[rvrtx] = color;
                
                for(int e: graph[rvrtx]){
                    if(vis[e] == -1){
                        queue.addLast(e);
                    }
                }
                
            }
            color = (color+1)%2;
            
        }
        return isBipartite;
    }
    
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        boolean isBipartite = true;
        int[] vis = new int[N];
        Arrays.fill(vis, -1);
        
        for(int i=0; i<N; i++){
            if(vis[i] == -1)
                isBipartite = isBipartite && isGraphBipartite(graph, i, vis);
        }
       return isBipartite;
        
    }
}