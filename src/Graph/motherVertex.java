package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class motherVertex {
    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V+1];
        int v = -1;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSUtil(i, adj, visited);
                v = i;
            }
        }

        boolean[] check = new boolean[V];
        DFSUtil(v, adj, check);
        for (boolean val : check) {
            if (!val) {
                return -1;
            }
        }
        return v;
    }

    static void DFSUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[v] = true;
        for (int x : adj.get(v)) {
            if (!visited[x]) {
                DFSUtil(x, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T --> 0) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i =0 ; i < V ;i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0 ; i < E ; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
            }
            System.out.println(findMotherVertex(V, adj));
        }
    }
}
