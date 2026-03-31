package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16951_블록놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int minTime = N;

        for (int h = 1; h <= 1000; h++) {
            int currentTime = 0;
            boolean isValid = true;

            for (int i = 0; i < N; i++) {
                int targetHeight = h + (i * K);

                if (targetHeight < 1) {
                    isValid = false;
                    break;
                }

                if (A[i] != targetHeight) {
                    currentTime++;
                }
            }

            if (isValid) {
                minTime = Math.min(minTime, currentTime);
            }
        }

        System.out.println(minTime);
    }
}
