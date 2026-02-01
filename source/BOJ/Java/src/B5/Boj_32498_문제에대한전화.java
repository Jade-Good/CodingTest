package B5;

import java.io.*;

public class Boj_32498_문제에대한전화 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(br.readLine()) % 2 == 1) {
                cnt++;
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
