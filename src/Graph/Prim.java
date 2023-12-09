package Graph;

import UnionFind.DSU;

import java.util.*;

public class Prim {

    public static int prims(int V, List<List<Integer>> edges, int start) {
        List<Integer> result = new ArrayList<>();
        int totalWeight = 0;

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        boolean[] visited = new boolean[V + 1];
        int[] weight = new int[V + 1];

        Arrays.fill(weight, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        pq.add(Arrays.asList(start, 0));
        weight[start] = 0;

        DSU uf = new DSU(V+1);

        int lastNode = start;

        while (!pq.isEmpty() && result.size() <= V) {
            List<Integer> current = pq.poll();
            int currentNode = current.get(0);
            int currentWeight = current.get(1);

            if (visited[currentNode]) {
                continue;
            }

            visited[currentNode] = true;
            totalWeight += currentWeight;
            result.add(currentNode);
            uf.union(currentNode, lastNode);
            lastNode = currentNode;

            List<Integer> neighbor = edges.get(currentNode);
            for (int i = 0; i < neighbor.size(); i += 2) {
                int nextNode = neighbor.get(i);
                int edgeWeight = neighbor.get(i + 1);

                if (!visited[nextNode] && edgeWeight < weight[nextNode] && !uf.isConnected(currentNode, nextNode)) {
                    weight[nextNode] = edgeWeight;
                    pq.add(Arrays.asList(nextNode, weight[nextNode]));
                }
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        int E = scan.nextInt();

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            edges.add(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < E; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();

            edges.get(u).addAll(Arrays.asList(v, w));
            edges.get(v).addAll(Arrays.asList(u, w));
        }

        int start = scan.nextInt();
        System.out.println(prims(V, edges, start));
        scan.close();
    }
}