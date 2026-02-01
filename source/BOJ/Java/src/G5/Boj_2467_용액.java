package G5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2467_용액 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Sort
        Arrays.sort(arr);

        // Two-Pointer
        int[] answer = new int[2];
        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE;

        while (left < right) {
            int now = arr[left] + arr[right];
            if (min > Math.abs(now)) {
                answer[0] = arr[left];
                answer[1] = arr[right];
                min = Math.abs(now);
            } else if (now < 0) {
                left++;
            } else {
                right--;
            }
        }

        // Output
        StringBuilder sb = new StringBuilder();
        sb.append(answer[0]).append(' ').append(answer[1]);

        bw.write(sb.toString());
        bw.flush();
    }
}
