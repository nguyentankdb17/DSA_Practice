package Stack;

import java.util.Stack;

public class trappingRainWater {
    static long trappingWater(int[] height, int n) {
        long res =0;
        if (n<=2) return 0;
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<n;i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int top = st.pop();
                if (st.isEmpty()) break;
                int distance = i - st.peek() -1;
                int boundedHeight = Math.min(height[i],height[st.peek()])-height[top];
                res += (long) distance * boundedHeight;
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {3,0,0,2,0,4};
        System.out.println(trappingWater(height, height.length));
    }
}
