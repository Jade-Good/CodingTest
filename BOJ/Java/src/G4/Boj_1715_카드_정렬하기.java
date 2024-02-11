package G4;

import java.io.*;
import java.util.PriorityQueue;

public class Boj_1715_카드_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        int n1, n2;

        while (pq.size() > 1) {
            n1 = pq.poll();
            n2 = pq.poll();
            answer += n1 + n2;
            pq.add(n1 + n2);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }
}