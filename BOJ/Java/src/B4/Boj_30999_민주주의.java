package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_30999_민주주의 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            int O = 0;
            int X = 0;
            for (char c : chars) {
                if (c == 'O') {
                    O++;
                } else {
                    X++;
                }
            }
            if (O > X) {
                result++;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
    }
}
