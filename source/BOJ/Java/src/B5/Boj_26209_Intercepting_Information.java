package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_26209_Intercepting_Information {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean flag = true;
        for (int i = 0; i < 8; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n > 1) {
                flag = false;
                break;
            }
        }
        if (flag) {
            bw.write("S");
        } else {
            bw.write("F");
        }
        bw.flush();
    }
}
