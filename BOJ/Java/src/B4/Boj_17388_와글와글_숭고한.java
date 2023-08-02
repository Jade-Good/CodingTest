package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_17388_와글와글_숭고한 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a + b + c >= 100) {
            bw.write("OK");
        } else if (a < b && a < c) {
            bw.write("Soongsil");
        } else if (b < a && b < c) {
            bw.write("Korea");
        } else {
            bw.write("Hanyang");
        }

        bw.flush();
    }
}
