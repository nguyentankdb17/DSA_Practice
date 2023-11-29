package Graph;

import java.util.*;

public class Prim {
    static class Edge implements Comparable<Edge> {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static int prims(int n, List<List<Edge>> edges, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        int[] weight = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            weight[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            visited[i] = false;
        }

        pq.add(new Edge(start, 0));
        weight[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.to;

            if (visited[currentNode]) {
                continue;
            }

            visited[currentNode] = true;

            for (Edge neighbor : edges.get(currentNode)) {
                int nextNode = neighbor.to;
                int edgeWeight = neighbor.weight;

                if (!visited[nextNode] && edgeWeight < weight[nextNode]) {
                    weight[nextNode] = edgeWeight;
                    parent[nextNode] = currentNode;
                    pq.add(new Edge(nextNode, edgeWeight));
                }
            }
        }

        int totalWeight = 0;
        for (int i = 1; i <= n; i++) {
            if (parent[i] != -1) {
                totalWeight += weight[i];
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberVertexs = sc.nextInt();
        int numberEdges = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= numberVertexs; i++) {
            graph.add(new ArrayList<Edge>());
        }
        int tmp = numberEdges;
        while (tmp-- > 0) {
            List<Integer> edgeList = new ArrayList<>();
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Edge(v,w));
            graph.get(v).add(new Edge(u,w));
        }

        int start = sc.nextInt();
        System.out.println(prims(numberVertexs, graph, start));
        sc.close();
    }
}