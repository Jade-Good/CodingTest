package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
           int first_abs = Math.abs(o1);
           int second_abs = Math.abs(o2);
           if (first_abs == second_abs)
               return o1 > o2 ? 1 : -1;         //절댓값이 같으면 음수 우선 정렬하기
           else
               return first_abs - second_abs;   //절댓값을 기준으로 정렬하기(음수면 뒤쪽이 큐에서 더 앞쪽)
        });
        for (int i = 0; i < n; i++) {
            int order = Integer.parseInt(br.readLine());
            if (order == 0) {
                if (queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            }
            else queue.add(order);
        }
    }
}
