package S4;

import java.io.*;
import java.util.Arrays;

public class Boj_1337_올바른_배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int minAdd = 5;
        for (int i = 0; i < N; i++) {
            int start = arr[i];
            int end = start + 4;
            int cnt = 0;

            for (int j = i; j < N; j++) {
                if (arr[j] > end) break;
                cnt++;
            }
            minAdd = Math.min(minAdd, 5 - cnt);
        }

        bw.write(Integer.toString(minAdd));
        bw.flush();
    }
}
