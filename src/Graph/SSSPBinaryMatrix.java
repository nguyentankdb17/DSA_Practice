package Graph;
import java.util.*;

public class SSSPBinaryMatrix {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (source[0]==destination[0] && source[1]==destination[1]) return 0;
        int[][] path = bfs(grid,source[0],source[1]);
        int res = path[destination[0]][destination[1]]-1;
        if (res==0) return -1;
        return res;
    }


    static int[][] bfs(int[][] grid, int startRow, int startCol) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] res = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        for (boolean[] arr : visited) {
            Arrays.fill(arr,false);
        }

        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        visited[startRow][startCol] = true;
        res[startRow][startCol] = 1;

        rowQueue.add(startRow);
        colQueue.add(startCol);

        while (!rowQueue.isEmpty()) {
            int currRow = rowQueue.poll();
            int currCol = colQueue.poll();

            for (int i=0 ;i < 4;i++) {
                int newRow = currRow + dr[i];
                int newCol = currCol + dc[i];

                if (newRow >=0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    if (grid[newRow][newCol]==0) {
                        res[newRow][newCol] = 0;
                        continue;
                    }
                    res[newRow][newCol] = res[currRow][currCol] + 1;
                    rowQueue.add(newRow);
                    colQueue.add(newCol);
                }
            }
        }
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }

    // Main method to test the code
    public static void main(String[] args) {

        // Initialize a 2D array to represent the maze
        int grid[][] = {{1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 0, 1}};

        int[] source = {0,0};
        int[] destination = {3,4};

        // Find the shortest path in the maze using DFS and print it
        int shortest = shortestPath(grid, source, destination);
        System.out.println("Shortest Path using DFS: " + shortest);
    }
}
