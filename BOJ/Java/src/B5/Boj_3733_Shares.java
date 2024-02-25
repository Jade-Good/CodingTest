package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_3733_Shares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = null;

        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);

            int N = Integer.parseInt(st.nextToken()) + 1;
            int S = Integer.parseInt(st.nextToken());

            sb.append(S / N).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
