package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_21965_드높은_남산_위에_우뚝_선 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean flag = true;
        int temp = 0;

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (temp == a) {
                bw.write("NO");
                bw.flush();
                return;
            }
            if (flag) { // 증가
                if (temp > a) {
                    flag = false;
                }
            } else { // 감소
                if (temp < a) {
                    bw.write("NO");
                    bw.flush();
                    return;
                }
            }
            temp = a;
        }
        bw.write("YES");
        bw.flush();
    }
}
