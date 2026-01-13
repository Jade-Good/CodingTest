package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_25551_멋쟁이_포닉스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int MW = Integer.parseInt(st.nextToken());
        int MB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int TW = Integer.parseInt(st.nextToken());
        int TB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int PW = Integer.parseInt(st.nextToken());
        int PB = Integer.parseInt(st.nextToken());

        int wbw = Math.min(MW, Math.min(TB, PW));
        int bwb = Math.min(MB, Math.min(TW, PB));

        if ((wbw == 0 && bwb > 0) || (bwb == 0 && wbw > 0)) {
            System.out.print(1);
        } else if (wbw == bwb) {
            System.out.print(wbw + bwb);
        } else {
            System.out.print(Math.min(wbw, bwb) * 2 + 1);
        }
    }
}
