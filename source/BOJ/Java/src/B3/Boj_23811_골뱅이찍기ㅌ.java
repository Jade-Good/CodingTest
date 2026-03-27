package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_23811_골뱅이찍기ㅌ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append("@@@@@");
                }
                sb.append('\n');
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append('@');
                }
                sb.append('\n');
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append("@@@@@");
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
