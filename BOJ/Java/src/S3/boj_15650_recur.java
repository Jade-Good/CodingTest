package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15650_recur {
    static int[] arr;
    static boolean[] visit;
    static int n, m;
    public static void test(String s) throws IOException {
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];

        recursion(0, 1);
    }

    private static void recursion(int idx, int start) {
        if (idx == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else {
            for (int i = start; i <= n; i++) {
                arr[idx] = i;
                recursion(idx + 1, i + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];

        recursion(0, 1);
    }
}
