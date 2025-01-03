package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_32403_전구주기맞추기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int min = 0;

        for (int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());
            for (int j = 0; j < time; j++) {
                if (T % (time - j) == 0 || T % (time + j) == 0) {
                    min += j;
                    break;
                }
            }
        }

        bw.write(Integer.toString(min));
        bw.flush();
    }
}
