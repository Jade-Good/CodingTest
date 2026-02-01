package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2491_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int inc_cnt = 1;
        int dec_cnt = 1;
        int max = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                inc_cnt++;
            } else {
                inc_cnt = 1;
            }
            if (arr[i] <= arr[i - 1]) {
                dec_cnt++;
            } else {
                dec_cnt = 1;
            }
            max = Math.max(max, Math.max(inc_cnt, dec_cnt));
        }

        bw.write(Integer.toString(max));
        bw.flush();
    }
}
