package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074 {
    static int answer;

    public static void test(String s) throws IOException {
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        answer = 0;

        int size = (int) Math.pow(2, n);

        recursion(size, r, c);
        System.out.println(answer);
    }

    private static void recursion(int len, int r, int c) {
        if (len == 1) {
            return;
        }

        int new_len = len / 2;

        if (r < new_len && c < new_len) {           // 1사분면
            recursion(new_len, r, c);
        } else if (r < new_len && c >= new_len) {   // 2사분면
            answer += (len * len) / 4;
            recursion(new_len, r, c - new_len);
        } else if (r >= new_len && c < new_len) {   // 3사분면
            answer += (len * len / 4) * 2;
            recursion(new_len, r - new_len, c);
        } else {                                    // 4사분면
            answer += (len * len / 4) * 3;
            recursion(new_len, r - new_len, c - new_len);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        answer = 0;

        int size = (int) Math.pow(2, n);

        recursion(size, r, c);
        System.out.println(answer);
    }
}
