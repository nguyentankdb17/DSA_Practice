package Graph;

import java.util.*;

public class connectedCellInGrid {
    static int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        int res = 0;
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        boolean[][] visited = new boolean[rows][cols];
        for (int i=0;i<rows;i++) {
            for (int j = 0; j <cols;j++) {
                if (!visited[i][j] && matrix.get(i).get(j)==1) {
                    res = Math.max(res, maxArea(matrix, visited, i, j));
                }
            }
        }
        return res;
    }

    static int maxArea(List<List<Integer>> matrix, boolean[][] visited,  int startRow, int startCol) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int count = 1;

        visited[startRow][startCol] = true;

        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        rowQueue.add(startRow);
        colQueue.add(startCol);

        while (!rowQueue.isEmpty()) {
            int currRow = rowQueue.poll();
            int currCol = colQueue.poll();

            for (int i = 0;i < 8;i++) {
                int newRow = currRow + dir[i][0];
                int newCol = currCol + dir[i][1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && !visited[newRow][newCol]) {
                    if (matrix.get(newRow).get(newCol)==0) {
                        continue;
                    }
                    count++;
                    visited[newRow][newCol] = true;
                    rowQueue.add(newRow);
                    colQueue.add(newCol);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();

        for (int i=0;i<n;i++) {
            List<Integer> tmp = new ArrayList<>();
            String[] row = sc.nextLine().split(" ");
            for (int j=0;j<m;j++) {
                tmp.add(Integer.parseInt(row[j]));
            }
            list.add(tmp);
        }

        System.out.println(connectedCell(list));
    }
}
