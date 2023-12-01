package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {

    static void dfs(int ch, boolean[] visited, List<Integer> res, List<List<Integer>> edges) {
        visited[ch] = true;
        res.add(ch);

        for (int i = 0; i < edges.get(ch).size(); i++) {
            if (!visited[edges.get(ch).get(i)])
                dfs(edges.get(ch).get(i), visited, res, edges);
        }
    }

    public static List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        boolean[] visited = new boolean[V];
        List<Integer> res = new ArrayList<>();
        dfs(0, visited, res, edges);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {

            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> edges = new ArrayList<>();
            for (int j = 0; j < V;j++) {
                edges.add(j, new ArrayList<Integer>());
            }

            for (int j = 0; j < E ;j++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                edges.get(u).add(v);
                edges.get(v).add(u);
            }

            List<Integer> res = dfsOfGraph(V, edges);

            for (Integer re : res) {
                System.out.print(re + " ");
            }
            System.out.println();
        }
    }
}
