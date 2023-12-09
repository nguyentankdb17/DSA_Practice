package Graph;

import java.util.*;

public class checkBipartite {
    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> graph)
    {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1 && !checkBipartite(i, graph, color, 0)) return false;
        }

        return true;
    }

    public static boolean checkBipartite(int node, ArrayList<ArrayList<Integer>> graph, int[] color, int currColor) {
        color[node] = currColor;
        for (int nbr : graph.get(node)) {

            if (color[nbr] == -1){
                int nbrColor = 1 - currColor;
                if (!checkBipartite(nbr, graph, color, nbrColor)) return false;
            }

            if (color[nbr] == currColor) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T --> 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i=0;i<V;i++) {
                adj.add(new ArrayList<Integer>());
            }
            for (int i=0; i<E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            System.out.println(isBipartite(V, adj) ? 1 : 0);
        }
    }
}
