package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_31780_불사조 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new ArrayDeque<>();
        que.offer(X);

        int sum = X;

        for (int i = 0; i < M; i++) {
            int size = que.size();
            for (int j = 0; j < size; j++) {
                int cur = que.poll();
                if (cur > 0) {
                    int temp = (int) Math.ceil(cur / 2.0);
                    que.offer(temp);
                    sum += temp;

                    temp = (int) Math.floor(cur / 2.0);
                    que.offer(temp);
                    sum += temp;
                }
            }
        }

        bw.write(Integer.toString(sum));
        bw.flush();
    }
}
