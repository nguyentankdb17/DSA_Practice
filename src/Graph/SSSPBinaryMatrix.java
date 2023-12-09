package Graph;
import java.util.*;

public class SSSPBinaryMatrix {
    // A Java program to find the shortest path in a maze using DFS algorithm
    private static int shortestPath;

    // Method to find the shortest path in a given maze
    public static int findShortestPath(int[][] maze, int X, int Y) {

        // Check if the maze is empty or null, if so return 0
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return 0;
        }

        // Initialize shortestPath to the maximum possible value
        shortestPath = Integer.MAX_VALUE;

        // Initialize a boolean array to keep track of visited cells
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        // Invoke the dfs() method to find the shortest path
        dfs(X+1, Y+1, maze, visited, 0, 0, 0);

        // Return the shortest path, or 0 if it was not found
        return shortestPath == Integer.MAX_VALUE ? 0 : shortestPath;
    }

    // Method to perform DFS traversal to find the shortest path
    private static void dfs(int N, int M,int[][] maze, boolean[][] visited, int row, int col, int distance) {

        // Check if the current cell is out of bounds, a wall or has already been visited
        if (row < 0 || row >= N || col < 0 || col >= M || maze[row][col] == 0 || visited[row][col]) {
            return;
        }

        // Check if the current cell is the destination, if so update the shortestPath variable and return
        if (row == N-1 && col == M-1) {
            shortestPath = Math.min(shortestPath, distance);
            return;
        }

        // Mark the current cell as visited
        visited[row][col] = true;

        // Explore all possible paths from the current cell
        dfs(N, M, maze, visited, row + 1, col, distance + 1);
        dfs(N, M, maze, visited, row - 1, col, distance + 1);
        dfs(N, M, maze, visited, row, col + 1, distance + 1);
        dfs(N, M, maze, visited, row, col - 1, distance + 1);

        // Unmark the current cell as visited
        visited[row][col] = false;
    }

    // Main method to test the code
    public static void main(String[] args) {

        // Initialize a 2D array to represent the maze
        int[][] maze = {
                {1, 1, 1, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
        };

        // Find the shortest path in the maze using DFS and print it
        int shortest = findShortestPath(maze,0,3);
        System.out.println("Shortest Path using DFS: " + shortest);
    }
}
