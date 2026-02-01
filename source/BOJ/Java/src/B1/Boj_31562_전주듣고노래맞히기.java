package B1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_31562_전주듣고노래맞히기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] music = new String[N];
        Map<String, int[]> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            music[i] = st.nextToken();
            String melodi = st.nextToken() + ' ' + st.nextToken() + ' ' + st.nextToken();

            if (map.containsKey(melodi)) {
                map.get(melodi)[0]++;
            } else {
                map.put(melodi, new int[]{1, i});
            }
        }

        for (int i = 0; i < M; i++) {
            String target = br.readLine();

            if (map.containsKey(target)) {
                int[] result = map.get(target);
                sb.append(result[0] == 1 ? music[result[1]] : '?');
            } else {
                sb.append('!');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}