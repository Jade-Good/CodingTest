package B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2443_별_찍기6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                sb.append(' ');
            }
            for (int j = 0; j < (N-i)*2 + 1; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
