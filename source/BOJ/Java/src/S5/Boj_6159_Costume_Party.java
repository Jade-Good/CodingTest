package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_6159_Costume_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] cow = new int[N];
        for (int i = 0; i < N; i++) {
            cow[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (cow[i] + cow[j] <= S) {
                    cnt++;
                }
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
