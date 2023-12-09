package Stack;

import java.util.Stack;

public class largestRectangleHistogram {
    public static long getMaxArea(long[] hist, long n) {
        long[] prev = prevSmaller(hist);
        long[] next = nextSmaller(hist);
        long maxArea = 0;
        for (int i = 0;i < n; i++) {
            long height = hist[i];
            long width = next[i] - prev[i] - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    static long[] prevSmaller(long[] hist) {
        long[] prev = new long[hist.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0;i < hist.length;i++) {
            while (!st.isEmpty() && (int) hist[st.peek()] >= hist[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                prev[i] = -1;
            } else {
                prev[i] = st.peek();
            }
            st.push(i);
        }
        return prev;
    }

    static long[] nextSmaller(long[] hist) {
        long[] next = new long[hist.length];
        Stack<Integer> st = new Stack<>();
        for (int i = hist.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && (int) hist[st.peek()] >= hist[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                next[i] = hist.length;
            } else {
                next[i] = st.peek();
            }
            st.push(i);
        }
        return next;
    }

    public static void main(String[] args) {
        long[] hist = {1, 2, 3, 4, 5};
        long result = getMaxArea(hist, hist.length);
        System.out.println("Largest Rectangle Area: " + result);
    }
}
