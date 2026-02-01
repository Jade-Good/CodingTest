package S5;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_15720_카우버거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int sum = 0;

        Integer[] ba = new Integer[B];
        Integer[] ca = new Integer[C];
        Integer[] da = new Integer[D];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            sum += ba[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            sum += ca[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            sum += da[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ba, Collections.reverseOrder());
        Arrays.sort(ca, Collections.reverseOrder());
        Arrays.sort(da, Collections.reverseOrder());

        sb.append(sum).append('\n');
        sum = 0;

        for (int i = 0; i < Math.max(B, Math.max(C, D)); i++) {
            if (i < B && i < C && i < D) {
                sum += (ba[i] + ca[i] + da[i]) * 0.9;
                continue;
            }
            if (i < B) sum += ba[i];
            if (i < C) sum += ca[i];
            if (i < D) sum += da[i];
        }

        sb.append(sum);

        bw.write(sb.toString());
        bw.flush();
    }
}
