package Graph;

import java.util.*;

public class shortestReachBFS {
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<Integer> dist = new ArrayList<>(Collections.nCopies(n + 1, -1));
        dist.set(s,0);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0;i<n+1;i++) {
            graph.add(new ArrayList<>());
        }
        for( List<Integer> edge : edges){
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        boolean[] visited = new boolean[n+1];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s]=true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    dist.set(next, dist.get(curr) + 6);
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        dist.remove(s);
        dist.remove(0);
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> edges = new ArrayList<>();
        int t = sc.nextInt();
        while (t --> 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                List<Integer> edge = new ArrayList<>(Arrays.asList(u, v));
                edges.add(edge);
            }
            int s = sc.nextInt();
            List<Integer> res = bfs(n, m, edges, s);
            for (int x : res) {
                System.out.print(x + " ");
            }
            System.out.println(res.size());
        }
    }
}
