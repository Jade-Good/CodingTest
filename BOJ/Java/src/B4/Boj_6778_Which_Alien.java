package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_6778_Which_Alien {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        if (a >= 3 && b <= 4) {
            sb.append("TroyMartian\n");
        }
        if (a <= 6 && b >= 2) {
            sb.append("VladSaturnian\n");
        }
        if (a <= 2 && b <= 3) {
            sb.append("GraemeMercurian\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
