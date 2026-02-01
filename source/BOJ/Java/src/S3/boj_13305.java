package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] road = new long[n - 1];
        long[] city = new long[n];
        int min_index = 0;
        long min = 1000000001;
        long r = 0;
        long answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
            r += road[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
            if (min > city[i] && i < n - 1) {
                min = city[i];
                min_index = i;
            }
        }

        n--;

        while (r > 0) {
            long len = 0;
            for (int i = n-1; i >= min_index; i--) {
                len += road[i];
            }

            answer += min * len;
            r -= len;

            n = min_index;
            min = 1000000001;
            for (int i = 0; i < n; i++) {
                if (city[i] < min) {
                    min_index = i;
                    min = city[i];
                }
            }
        }
        System.out.println(answer);
    }
}
