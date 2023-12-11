package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class bfsMatrix {
    public static void bfs(int[][] matrix, boolean[][] visited, int startRow, int startCol ) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        visited[startRow][startCol] = true;

        rowQueue.add(startRow);
        colQueue.add(startCol);

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!rowQueue.isEmpty()) {
            int currentRow = rowQueue.poll();
            int currentCol = colQueue.poll();

            System.out.println(matrix[currentRow][currentCol] + " ");

            for (int i = 0;i < 4;i++) {
                int newRow = currentRow + dr[i];
                int newCol = currentCol + dc[i];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                   && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    rowQueue.add(newRow);
                    colQueue.add(newCol);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Mảng để đánh dấu các ô đã thăm
        boolean[][] visited = new boolean[rows][cols];

        // Gọi hàm BFS từ ô đầu tiên
        bfs(matrix, visited, 0, 0);
    }
}
