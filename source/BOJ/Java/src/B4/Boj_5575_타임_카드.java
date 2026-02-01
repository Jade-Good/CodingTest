package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_5575_타임_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start =
                    (Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken())) * 60 + Integer.parseInt(
                            st.nextToken());
            int end =
                    (Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken())) * 60 + Integer.parseInt(
                            st.nextToken()) - start;
            sb.append(end / 3600).append(' ').append(end % 3600 / 60).append(' ').append(end % 60).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
