package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2961 {
    static int n;
    static long answer = Long.MAX_VALUE;
    static long[][] arr;
    static boolean[] visit;
    public static void test (String s) throws IOException {
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        arr = new long[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        recursion(0, 1, 0);

        System.out.println(answer);
    }
    private static void recursion(int idx, long sin, long ssen) { // idx : 직전까지 고려 된 원소 수
        if (idx == n) {
            if (ssen != 0&& Math.abs(sin-ssen) < answer)
                answer = Math.abs(sin-ssen);
        }
        else {
            visit[idx] = true;
            recursion(idx + 1, sin * arr[idx][0], ssen + arr[idx][1]);
            visit[idx] = false;
            recursion(idx + 1, sin, ssen);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visit = new boolean[n];
        arr = new long[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        recursion(0, 1, 0);

        System.out.println(answer);
    }
}
