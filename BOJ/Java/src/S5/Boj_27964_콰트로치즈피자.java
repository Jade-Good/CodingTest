package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_27964_콰트로치즈피자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(st.nextToken());
        }

        if (set.size() < 4) {
            bw.write("sad");
        } else {
            int cnt = 0;
            for (String s : set) {
                if (s.endsWith("Cheese")) {
                    cnt++;
                }
            }

            if (cnt >= 4) {
                bw.write("yummy");
            } else {
                bw.write("sad");
            }
        }
        bw.flush();
    }
}
