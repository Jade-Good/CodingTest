package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_15059_Hard_choice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ca = Integer.parseInt(st.nextToken());
        int ba = Integer.parseInt(st.nextToken());
        int pa = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int cb = Integer.parseInt(st.nextToken());
        int bb = Integer.parseInt(st.nextToken());
        int pb = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(
                -1 * (Math.min(0, ca - cb) +
                        Math.min(0, ba - bb) +
                        Math.min(0, pa - pb))
        ));
        bw.flush();
    }
}
