package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9019_DSLR {
    private static class Calc {
        String history;
        Deque<Integer> dq;

        public Calc(String history, Deque<Integer> dq) {
            this.history = history;
            this.dq = dq;
        }

        @Override
        public String toString() {
            return "Calc{" +
                    "history='" + history + '\'' +
                    ", dq=" + dq +
                    '}';
        }
    }

    private static final int MAX = 10_000;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[MAX];

            // BFS
            Queue<Calc> que = new ArrayDeque<>();
            que.offer(new Calc("", make_Dq(A)));
//            System.out.println(que);

            while (!que.isEmpty()) {
                Calc calc = que.poll();
                int num = make_num(calc.dq);

                // B발견하면 종료
                if (num == B) {
                    System.out.println(calc.history);
                    break;
                }

                if (!visited[num]) {
                    visited[num] = true;

                    // D 연산
                    int temp = (num * 2) % MAX;
                    if (!visited[temp]) {
                        que.offer(new Calc(calc.history + "D", make_Dq(temp)));
                    }

                    // S 연산
                    temp = num == 0 ? 9999 : num-1;
                    if(!visited[temp]) {
                        que.offer(new Calc(calc.history + "S", make_Dq(temp)));
                    }

                    // L 연산
                    calc.dq.addLast(calc.dq.pollFirst());
                    temp = make_num(calc.dq);
                    if(!visited[temp]) {
                        que.offer(new Calc(calc.history + "L", make_Dq(temp)));
                    }

                    // R 연산
                    calc.dq.addFirst(calc.dq.pollLast());
                    calc.dq.addFirst(calc.dq.pollLast());
                    temp = make_num(calc.dq);
                    if(!visited[temp]) {
                        que.offer(new Calc(calc.history + "R", make_Dq(temp)));
                    }
                }
            }
        }
    }

    private static int make_num(Deque<Integer> dq) { // dq -> int
        Deque<Integer> copy = new ArrayDeque<>(dq);
        int num = 0;
        while (!copy.isEmpty()) {
            num = num * 10 + copy.pollFirst();
        }
        return num;
    }

    private static Deque<Integer> make_Dq(int num) { // int -> dq(0채우기)
        Deque<Integer> result = new ArrayDeque<>();
        while (num > 0) {
            result.addFirst(num % 10);
            num /= 10;
        }
        while (result.size() < 4) {
            result.addFirst(0);
        }
        return result;
    }
}
