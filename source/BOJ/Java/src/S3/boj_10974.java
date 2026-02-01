package S3;

import java.util.Scanner;
import java.util.Stack;

public class boj_10974 {
    static Stack<Integer> stack;
    private static void dfs(int d, StringBuilder sb) {
        if (stack.size() == d) {
            for (int i :
                    stack) {
                sb.append(i+" ");
            }
            sb.append("\n");
        }
        for (int i = 1; i <= d; i++) {
            if (!stack.contains(i)) {
                stack.push(i);
                dfs(d, sb);
                stack.pop();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        stack = new Stack<>();

        dfs(n, sb);

        System.out.print(sb.toString());
    }
}
