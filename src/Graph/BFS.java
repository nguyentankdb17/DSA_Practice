package Graph;

import java.util.*;

public class BFS {

    static List<Integer> bfsOfGraph(int V, List<List<Integer>> edges, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            result.add(currentNode);

            for (int nextNode : edges.get(currentNode)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
        return result;
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

            int start = sc.nextInt();
            List<Integer> res = bfsOfGraph(V, edges, start);

            for (Integer re : res) {
                System.out.print(re + " ");
            }
            System.out.println();
        }
    }
}
