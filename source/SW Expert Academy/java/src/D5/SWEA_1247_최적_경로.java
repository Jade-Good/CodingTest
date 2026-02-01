package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적_경로 {

    private static int n, answer, visitList[];
    private static Pair[] client;

    public static void main(String[] args) {

    }
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // TestCase
        for (int t = 1; t <= T; t++) {
            // Input
            answer = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            visitList = new int[n + 2];
            for (int i = 0; i < n + 2; i++) {
                visitList[i] = i;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());

            client = new Pair[n + 2];
            client[0] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            client[n + 1] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 1; i < n + 1; i++) {
                client[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // recursion
            do {
                work(1, 0);
            } while (np());

            System.out.println("#" + t + " " + answer);
        }
    }

    private static void work(int idx, int length) {
        if (idx == visitList.length) {
            answer = Math.min(answer, length);
            return;
        }

        int new_len = distance(visitList[idx - 1], visitList[idx]);

        if (answer > length + new_len) {
            work(idx + 1, length + new_len);
        }
    }

    private static int distance(int a, int b) {
        return Math.abs(client[a].x - client[b].x) + Math.abs(client[a].y - client[b].y);
    }

    private static boolean np() {
        int size = n + 1;

        int i = size - 1;
        while (i > 1 && visitList[i - 1] >= visitList[i])
            i--;

        if (i == 1) return false;

        int j = size - 1;
        while (visitList[i - 1] >= visitList[j]) --j;

        swap(i - 1, j);

        int k = size - 1;
        while (i < k) {
            swap(i++, k--);
        }
        return true;
    }

    private static void swap(int i, int j) {
        int temp = visitList[i];
        visitList[i] = visitList[j];
        visitList[j] = temp;
    }

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
