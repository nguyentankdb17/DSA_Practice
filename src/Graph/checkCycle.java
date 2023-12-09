package Graph;


import java.util.ArrayList;
import java.util.Arrays;

public class checkCycle {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V+1];
        int[] parent = new int[V+1];
        Arrays.fill(parent, -1);
        parent[0] = 0;
        return dfs(0,visited,parent,adj);
    }

    public boolean dfs(int ch, boolean[] visited, int[] parent, ArrayList<ArrayList<Integer>> edges) {
        visited[ch] = true;

        for (int i = 0; i < edges.get(ch).size(); i++) {

            if (!visited[edges.get(ch).get(i)]) {
                int p1 = parent[ch];
                int p2 = parent[edges.get(ch).get(i)];
                if (p1 != -1 && p2 != -1 && p1==p2) {
                    return true;
                } else {
                    p2 = p1;
                    dfs(edges.get(ch).get(i),visited,parent,edges);
                }
            }
        }
        return false;
    }
}
