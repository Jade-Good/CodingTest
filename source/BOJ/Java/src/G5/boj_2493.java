package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493 {
    public static void test (String s) throws IOException {
        StringTokenizer st = new StringTokenizer(s);

        // input
        int n = Integer.parseInt(st.nextToken());

        // stack 초기화
        Stack<Top> stack = new Stack<>();
        stack.push(new Top(1, Integer.parseInt(st.nextToken())));

        StringBuilder sb = new StringBuilder();
        sb.append(0);

        for (int i = 2; i <= n; i++) {
            //System.out.println(stack);
            Top top;
            int height = Integer.parseInt(st.nextToken());

            boolean flag = true;
            while (!stack.isEmpty()) {
                top = stack.pop();
                if (top.height > height) {
                    sb.append(' ').append(top.idx);
                    stack.push(top);
                    flag = false;
                    break;
                }
            }
            if (flag && stack.isEmpty())
                sb.append(' ').append(0);

            stack.push(new Top(i, height));
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // stack 초기화
        Stack<Top> stack = new Stack<>();
        stack.push(new Top(1, Integer.parseInt(st.nextToken())));

        StringBuilder sb = new StringBuilder();
        sb.append(0);

        for (int i = 2; i <= n; i++) {
            Top top;
            int height = Integer.parseInt(st.nextToken());

            boolean flag = true;
            while (!stack.isEmpty()) {
                top = stack.pop();
                if (top.height > height) {
                    sb.append(' ').append(top.idx);
                    stack.push(top);
                    flag = false;
                    break;
                }
            }
            if (flag && stack.isEmpty())
                sb.append(' ').append(0);

            stack.push(new Top(i, height));
        }

        System.out.println(sb);
    }

    private static class Top {
        int idx;
        int height;

        public Top(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Top{" +
                    "idx=" + idx +
                    ", height=" + height +
                    '}';
        }
    }
}
