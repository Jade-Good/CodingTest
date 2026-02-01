package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_25166_배고픈_아리의_샌드위치_구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] coins = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
        int sand = Integer.parseInt(st.nextToken());

        if (sand <= 1023) {
            bw.write("No thanks");
        } else {

            sand -= 1023;
            int kugii = Integer.parseInt(st.nextToken());
            boolean[] check = new boolean[10];

            for (int i = 9; i >= 0; i--) {
                if (kugii >= coins[i]) {
                    check[i] = true;
                    kugii -= coins[i];
                }
            }

            for (int i = 9; i >= 0; i--) {
                if (check[i] && sand >= coins[i]) {
                    sand -= coins[i];
                }
            }

            if (sand == 0) {
                bw.write("Thanks");
            } else {
                bw.write("Impossible");
            }
        }

        bw.flush();
    }
}
