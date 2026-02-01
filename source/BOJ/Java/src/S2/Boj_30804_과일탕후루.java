package S2;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_30804_과일탕후루 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cntList = new int[10];
        int max = 0;
        int nowCnt = 0;
        int start = 0;

        for (int end = 0; end < N; end++) {
            if (++cntList[arr[end]] == 1) {
                if (++nowCnt > 2) {
                    max = Math.max(max, end - start);
                    while (start <= end) {
                        if (--cntList[arr[start++]] == 0) nowCnt--;
                        if (nowCnt <= 2) break;
                    }
                }
            }
        }

        max = Math.max(max, N - start);

        bw.write(Integer.toString(max));
        bw.flush();
    }
}
