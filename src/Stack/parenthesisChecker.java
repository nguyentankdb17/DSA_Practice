package Stack;

import java.util.Scanner;
import java.util.Stack;

public class parenthesisChecker {
    static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c=='(' || c=='[' || c=='{') st.push(c);
            else if ((!st.isEmpty()) && ((c==')' && st.peek() == '(') ||
                                         (c==']' && st.peek() == '[') ||
                                         (c=='}' && st.peek() == '{'))) {
                st.pop();
            }
            else return false;
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i <t; i++) {
            String str = sc.nextLine();
            System.out.println(str);
            System.out.println(check(str) ? "YES" : "NO");
        }
    }
}
