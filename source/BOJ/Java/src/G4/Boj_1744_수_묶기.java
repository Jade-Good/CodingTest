package G4;

import java.io.*;
import java.util.Arrays;

public class Boj_1744_수_묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 0;
        int right = N - 1;
        int left = 0;

        while (right > 0) {
            if (arr[right] > 1 && arr[right - 1] > 1) {
                answer += arr[right] * arr[right - 1];
            } else break;
            right -= 2;
        }

        while (left < right) {
            if (arr[left] < 1 && arr[left + 1] < 1) {
                answer += arr[left] * arr[left + 1];
            } else break;
            left += 2;
        }

        for (int i = left; i <= right; i++) {
            answer += arr[i];
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
