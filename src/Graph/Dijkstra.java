package Graph;

import java.util.*;

public class Dijkstra {
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

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Edge(start, 0));
        distance[start] = 0;

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

                if (!visited[nextNode] && distance[currentNode] + edgeWeight < distance[nextNode]) {
                    distance[nextNode] = distance[currentNode] + edgeWeight;
                    pq.add(new Edge(nextNode, distance[nextNode]));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int x : distance) {
            if (x == Integer.MAX_VALUE) {
                res.add(-1);
                continue;
            }
            res.add(x);
        }
        return res.subList(1, res.size());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();

        for (int k = 0; k < cases; k++) {
            List<List<Integer>> edges = new ArrayList<>();
            int n = scan.nextInt();
            int edge = scan.nextInt();
            for (int i = 0; i < edge; i++) {
                List<Integer> edge1 = new ArrayList<>();
                List<Integer> edge2 = new ArrayList<>();
                int u = scan.nextInt();
                int v = scan.nextInt();
                int w = scan.nextInt();

                edge1.add(u);
                edge1.add(v);
                edge1.add(w);
                edges.add(edge1);

                edge2.add(v);
                edge2.add(u);
                edge2.add(w);
                edges.add(edge2);
            }

            int startNode = scan.nextInt();

            List<Integer> distances = shortestReach(n, edges, startNode);

            for (int i = 0; i < n; i++) {
                if (distances.get(i) == 0)
                    continue;
                System.out.print(distances.get(i) + " ");

            }
            System.out.println();
        }
    }
}
