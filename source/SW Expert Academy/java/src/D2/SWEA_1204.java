package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[101];
            for (int j = 0; j < 1000; j++) {
                arr[Integer.parseInt(st.nextToken())]++;
            }

            int max = 0, answer = -1;
            for (int j = 0; j < 101; j++) {
                if (arr[j] >= max) {
                    max = arr[j];
                    answer = j;
                }
            }
            System.out.printf("#%d %d\n ", i, answer);
        }
    }
}
