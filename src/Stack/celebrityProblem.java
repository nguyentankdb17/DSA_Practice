package Stack;

import java.util.Stack;

public class celebrityProblem {
    static int celebrity(int[][] matrix, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int p1 = stack.pop();
            int p2 = stack.pop();

            if (knows(matrix,p1,p2)) {
                stack.push(p2);
            } else {
                stack.push(p1);
            }
        }

        int res = stack.pop();
        for (int i = 0; i < n; i++) {
            if ( i != res && (knows(matrix,res,i) || !knows(matrix,i,res)) ) {
                return -1;
            }
        }
        return res;
    }

    static boolean knows(int[][] matrix, int p1, int p2) {
        return matrix[p1][p2] == 1;
    }
}
