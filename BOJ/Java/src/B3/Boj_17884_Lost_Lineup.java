package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_17884_Lost_Lineup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        answer[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            answer[Integer.parseInt(st.nextToken()) + 1] = i;
        }

        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
