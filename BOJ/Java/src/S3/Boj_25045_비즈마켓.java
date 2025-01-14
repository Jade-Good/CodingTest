package S3;

import java.io.*;
import java.util.*;

public class Boj_25045_비즈마켓 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> maxA = new PriorityQueue<>(Collections.reverseOrder()); // A를 최대 힙
        PriorityQueue<Integer> minB = new PriorityQueue<>(); // B를 최소 힙

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            maxA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            minB.add(Integer.parseInt(st.nextToken()));
        }

        long sum = 0;

        while (!maxA.isEmpty() && !minB.isEmpty()) {
            int a = maxA.poll(); // 가장 큰 만족도 아이템
            int b = minB.poll(); // 가장 작은 비용을 지불할 고객

            if (a >= b) {
                sum += a - b;
            }
            // else의 경우: 거래 불가능하므로 진행하지 않고 다음 고객을 봄.
        }

        System.out.println(sum);
    }
}
