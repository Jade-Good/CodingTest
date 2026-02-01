package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074_2 {
    static int answer;

    public static void test(String s) throws IOException {
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        answer = 0;

        recursion((int) Math.pow(2, n), r, c);
        System.out.println(answer);
    }

    private static void recursion(int n, int x, int y) { // 분할 탐색
        if (n == 1) {
            return;
        }

        int new_size = n / 2;

        if (x < new_size && y < new_size) {             // 1사분면
            recursion(new_size, x, y);
        } else if (x < new_size && y >= new_size) {     // 2사분면
            answer += (n * n) / 4;
            recursion(new_size, x, y - new_size);
        } else if (x >= new_size && y < new_size) {     // 3사분면
            answer += (n * n) / 4 * 2;
            recursion(new_size, x-new_size, y);
        } else {                                        // 4사분면
            answer += (n * n) / 4 * 3;
            recursion(new_size, x- new_size, y - new_size);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        answer = 0;

        recursion((int) Math.pow(2, n), r, c);
        System.out.println(answer);
    }
}
