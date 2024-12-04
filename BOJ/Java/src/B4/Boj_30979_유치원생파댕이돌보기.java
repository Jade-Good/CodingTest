package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_30979_유치원생파댕이돌보기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
        }

        bw.write(T > sum ? "Padaeng_i Cry" : "Padaeng_i Happy");
        bw.flush();
    }
}
