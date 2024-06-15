package S3;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_25945_컨테이너_재배치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Integer[] containers = new Integer[n];
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum += containers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(containers, Collections.reverseOrder());

        int avg = (int) (sum / n);
        int remainder = (int) (sum % n);

        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = avg + (i < remainder ? 1 : 0);
        }

        long moveCnt = 0;
        for (int i = 0; i < n; i++) {
            if (containers[i] > target[i]) {
                moveCnt += containers[i] - target[i];
            }
        }

        bw.write(Long.toString(moveCnt));
        bw.flush();
    }
}