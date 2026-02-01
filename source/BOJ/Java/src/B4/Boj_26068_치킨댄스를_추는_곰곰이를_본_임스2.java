package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_26068_치킨댄스를_추는_곰곰이를_본_임스2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt((br.readLine().split("-"))[1]);
            if (x <= 90) {
                cnt++;
            }
        }
        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
