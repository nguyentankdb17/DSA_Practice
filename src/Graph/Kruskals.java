package Graph;

import UnionFind.DSU;

import java.util.*;

public class Kruskals {

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.get(2), b.get(2)));

        for (int i = 0; i < gFrom.size(); i++) {
            List<Integer> edge = new ArrayList<>();
            edge.add(gFrom.get(i) - 1);
            edge.add(gTo.get(i) - 1);
            edge.add(gWeight.get(i));
            pq.add(edge);
        }

        DSU uf = new DSU(pq.size());
        int edgeAdded = 0;
        int result = 0;

        while (!pq.isEmpty() && edgeAdded < gNodes - 1) {
            List<Integer> edge = pq.poll();
            if (!uf.isConnected(edge.get(0), edge.get(1))) {
                uf.union(edge.get(0), edge.get(1));
                result += edge.get(2);
                edgeAdded++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gNodes = sc.nextInt();
        int gEdges = sc.nextInt();

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        for (int i = 0; i < gEdges; i++) {
            gFrom.add(sc.nextInt());
            gTo.add(sc.nextInt());
            gWeight.add(sc.nextInt());
        }

        int res = kruskals(gNodes, gFrom, gTo, gWeight);
        System.out.println(res);
    }
}
