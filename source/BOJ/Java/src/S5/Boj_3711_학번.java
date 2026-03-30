package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3711_학번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int G = Integer.parseInt(br.readLine());
            int[] arr = new int[G];

            for (int i = 0; i < G; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            int m = 1;
            int[] visited = new int[1000001]; // 최대 학번 기준

            while (true) {
                boolean valid = true;

                for (int i = 0; i < G; i++) {
                    int r = arr[i] % m;

                    if (visited[r] == m) { // 이미 방문
                        valid = false;
                        break;
                    }

                    visited[r] = m;
                }

                if (valid) {
                    System.out.println(m);
                    break;
                }

                m++;
            }
        }
    }
}
