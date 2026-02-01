package D0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ssafy_b_3_No3_SW_문제해결_기본_8일차_암호문3 {
    private static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int bitmask = (1 << n) - 1;

            sb.append('#').append(t).append(' ').append((m & bitmask) == bitmask ? "ON" : "OFF").append('\n');
        }
        System.out.println(sb);
    }
}
