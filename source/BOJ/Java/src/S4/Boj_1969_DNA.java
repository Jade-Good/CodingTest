package S4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1969_DNA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] chars = new char[N][M];
        char[] charset = {'A', 'C', 'G', 'T'};

        for (int i = 0; i < N; i++) {
            chars[i] = br.readLine().toCharArray();
        }

        int sum = 0;

        for (int i = 0; i < M; i++) {
            int[] cnt = new int[4];
            for (int j = 0; j < N; j++) {
                switch (chars[j][i]) {
                    case 'A':
                        cnt[0]++;
                        break;
                    case 'C':
                        cnt[1]++;
                        break;
                    case 'G':
                        cnt[2]++;
                        break;
                    case 'T':
                        cnt[3]++;
                        break;
                }
            }

            int max = -1;
            int idx = -1;

            for (int j = 0; j < 4; j++) {
                if (cnt[j] > max) {
                    max = cnt[j];
                    idx = j;
                }
            }

            sb.append(charset[idx]);
            sum += N - max;
        }

        sb.append('\n').append(sum);

        bw.write(sb.toString());
        bw.flush();
    }

}
