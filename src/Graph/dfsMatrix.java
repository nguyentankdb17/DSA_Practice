package Graph;

public class dfsMatrix {
    public static void dfs(int[][] matrix, boolean[][] visited, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        visited[row][col] = true;

        System.out.println(matrix[row][col] + " ");

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                    && !visited[newRow][newCol]) {
                dfs(matrix, visited, newRow, newCol);
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

        // Gọi hàm DFS từ ô đầu tiên
        dfs(matrix, visited, 0, 0);
    }
}
