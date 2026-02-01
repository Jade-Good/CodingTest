package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_14581_팬들에게_둘러싸인_홍준 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String id = br.readLine();
        String fan = ":fan:";

        for (int i = 0; i < 3; i++) {
            sb.append(fan);
        }
        sb.append('\n').append(fan).append(':').append(id).append(':').append(fan).append('\n');
        for (int i = 0; i < 3; i++) {
            sb.append(fan);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
