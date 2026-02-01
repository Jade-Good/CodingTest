package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int min_pack = 1000;
        int min = 1000;
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            if (pack < min_pack) min_pack = pack;
            if (one < min) min = one;
        }

        int answer = 0;
        answer += min * 6 < min_pack ? (n/6) * (6 * min) : n/6 * min_pack;
        answer += min * (n%6) < min_pack ? min * (n%6) : min_pack;
        System.out.println(answer);
    }
}