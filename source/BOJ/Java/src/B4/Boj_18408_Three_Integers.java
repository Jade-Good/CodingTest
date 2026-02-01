package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_18408_Three_Integers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                cnt++;
            }
        }
        if (cnt > 1) {
            bw.write('1');
        } else {
            bw.write('2');
        }
        bw.flush();
    }
}
