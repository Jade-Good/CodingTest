package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_9037_Thecandywar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] % 2 == 1) arr[i]++;
            }

            int cnt = 0;

            while (!isEqual(arr)) {
                cnt++;
                arr[N - 1] /= 2;
                int temp = arr[N - 1];

                for (int i = N - 2; i >= 0; i--) {
                    arr[i] /= 2;
                    arr[i + 1] += arr[i];
                    if (arr[i + 1] % 2 == 1) arr[i + 1]++;
                }

                arr[0] += temp;
                if (arr[0] % 2 == 1) arr[0]++;
            }

            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isEqual(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) return false;
        }
        return true;
    }
}
