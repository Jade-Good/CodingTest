package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_26766_Serca {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(
                    " @@@   @@@ \n@   @ @   @\n@    @    @\n@         @\n @       @ \n  @     @  \n   @   @   \n    @ @    \n     @     \n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
