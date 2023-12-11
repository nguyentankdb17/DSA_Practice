package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class minimumCostPathInGrid {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Cell {
        int x;
        int y;
        int dis;

        public Cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static int minimumCostPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dis = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        dis[0][0] = grid[0][0];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparing(a -> a.dis));
        pq.add(new Cell(0, 0 , dis[0][0]));
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            for (int i = 0;i < 4;i++) {
                int row = curr.x + dr[i];
                int col = curr.y + dc[i];

                if (row < rows && row >=0 && col >= 0 && col < cols) {
                    if (dis[row][col] > dis[curr.x][curr.y] + grid[row][col]) {
                        if (dis[row][col] != Integer.MAX_VALUE) {
                            Cell adj = new Cell(row,col,dis[row][col]);
                            pq.remove(adj);
                        }
                        dis[row][col] = dis[curr.x][curr.y] + grid[row][col];
                        pq.add(new Cell(row, col, dis[row][col]));
                    }
                }
            }
        }
        return dis[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 31, 100, 65, 12, 18 },
                { 10, 13, 47, 157, 6 },
                { 100, 113, 174, 11, 33 },
                { 88, 124, 41, 20, 140 },
                { 99, 32, 111, 41, 20 } };
        System.out.println(minimumCostPath(grid));
    }
}
