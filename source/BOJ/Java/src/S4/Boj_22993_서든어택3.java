package S4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_22993_서든어택3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long jun_one = arr[0];
        arr[0] = 0;

        Arrays.sort(arr);

        int idx = 0;

        while (++idx < N) {
            if (arr[idx] < jun_one) {
                jun_one += arr[idx];
            } else {
                break;
            }
        }

        bw.write(idx == N ? "Yes" : "No");
        bw.flush();
    }
}
