package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_28136_원탁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < n; i++) { // 자르는 횟수
            if (arr[i] >= arr[(i + 1) % n]) {
                result++;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
    }
}
