package Lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GBC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] limit = new int[N][2];
        int[][] test = new int[M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            limit[i][0] = Integer.parseInt(st.nextToken());
            limit[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            test[i][0] = Integer.parseInt(st.nextToken());
            test[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int li = 0; // 리미트 인덱스
        int ti = 0; // 테스트 인덱스
        int ll = limit[li][0]; // 리미트 길이
        int tl = test[ti][0]; // 테스트 길이
        int ls = limit[li][1]; // 리미트 스피드
        int ts = test[ti][1]; // 테스트 스피드

        for (int i = 1; i <= 100; i++) { // 현재 위치
            if (--ll < 0) {
                ll = limit[++li][0] - 1;
                ls = limit[li][1];
            }
            if (--tl < 0) {
                tl = test[++ti][0] - 1;
                ts = test[ti][1];
            }
            if (ls < ts) {
                max = Math.max(max, ts - ls);
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();
    }
}
