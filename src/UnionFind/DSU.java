package UnionFind;

public class DSU {
    private int[] parent;

    public DSU(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            return find(parent[x]);
        }
        return x;
    }

    public void union(int x, int y) {
        parent[find(y)] = find(x);
    }

    public boolean isConnected(int x, int y) {
        return (find(x) == find(y));
    }
}
