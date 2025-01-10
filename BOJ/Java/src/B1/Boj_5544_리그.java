package B1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_5544_리그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][2];
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i][1] = i;
        }

        for (int i = 0; i < N * (N - 1) / 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            if (C > D) {
                arr[A][0] += 3;
            } else if (C < D) {
                arr[B][0] += 3;
            } else {
                arr[A][0]++;
                arr[B][0]++;
            }
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> -a[0]));

        int rank = 1;

        for (int i = 0; i < N; i++) {
            if (i != 0 && arr[i][0] == arr[i - 1][0]) {
                result[arr[i][1]] = rank;
            } else {
                result[arr[i][1]] = rank = i + 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
