package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493_2 {
    static int top, idx, height;
    static int[][] stack;

    public static void test(String s) throws IOException {
        StringTokenizer st = new StringTokenizer(s);

        // input
        int n = Integer.parseInt(st.nextToken());

        // stack 초기화
        stack = new int[500_001][2];
        top = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            idx = i;
            height = Integer.parseInt(st.nextToken());

            sb.append(find()).append(' ');
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static int find() {
        while (top > 0) {
            if (stack[top - 1][1] > height) {
                stack[top][0] = idx;
                stack[top][1] = height;
                return stack[top++ - 1][0];
            }
            top--;
        }

        stack[top][0] = idx;
        stack[top][1] = height;
        top++;

        return 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        int n = Integer.parseInt(br.readLine());

        // stack 초기화
        stack = new int[500_001][2];
        top = 0;

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            idx = i;
            height = Integer.parseInt(st.nextToken());

            sb.append(find()).append(' ');
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
