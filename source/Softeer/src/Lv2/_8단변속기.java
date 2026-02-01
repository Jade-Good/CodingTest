package Lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _8단변속기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bef = Integer.parseInt(st.nextToken());
        int now = Integer.parseInt(st.nextToken());
        boolean flag = bef < now;

        for (int i = 2; i < 8; i++) {
            bef = now;
            now = Integer.parseInt(st.nextToken());
            if (!((flag && bef < now) || (!flag && bef > now))) {
                bw.write("mixed");
                bw.flush();
                return;
            }
        }
        bw.write(flag ? "ascending" : "descending");
        bw.flush();
    }
}

