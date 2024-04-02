package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_27918_탁구_경기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            if (br.readLine().charAt(0) == 'D') {
                x++;
            } else {
                y++;
            }

            if (Math.abs(x - y) >= 2) {
                break;
            }
        }

        sb.append(x).append(':').append(y);
        bw.write(sb.toString());
        bw.flush();
    }
}
