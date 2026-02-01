package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_귀찮아_SIB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long total = 0L;
        long suffixSum = 0L;

        for (int i = n - 1; i >= 0; i--) {
            total += arr[i] * suffixSum;
            suffixSum += arr[i];
        }
        bw.write(Long.toString(total));
        bw.flush();
    }
}
