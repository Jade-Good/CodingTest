package B1;

import java.io.*;

public class Boj_15881_PenPineappleApplePen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int idx = 0;

        char[] ppap = {'p', 'P', 'A', 'p'};
        char[] chars = br.readLine().toCharArray();

        for (char c : chars) {

            if (ppap[idx] == c) {
                if (++idx == 4) {
                    cnt++;
                    idx = 0;
                }
            } else if (c == 'p') {
                idx = 1;
            } else {
                idx = 0;
            }

        }

        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
