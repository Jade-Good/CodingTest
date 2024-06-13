package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_2358_평행선 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (!row.containsKey(x)) {
                row.put(x, 0);
            } else if (row.get(x) == 1) {
                cnt++;
            }
            row.put(x, row.get(x) + 1);
            if (!col.containsKey(y)) {
                col.put(y, 0);
            } else if (col.get(y) == 1) {
                cnt++;
            }
            col.put(y, col.get(y) + 1);
        }
        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
