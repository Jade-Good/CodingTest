package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14891_톱니바퀴 {
    private static final int TN = 8, GN = 4; // 톱니 수, 바퀴 수
    private static int[][] gears; // 톱니 상태
    private static int[] firsts;

    public static void test(String s) throws IOException {
        // input
        StringTokenizer st = new StringTokenizer(s);
        gears = new int[GN][TN];
        for (int i = 0; i < GN; i++) {
            String[] ss = st.nextToken().split("");
            for (int j = 0; j < TN; j++) {
                gears[i][j] = Integer.parseInt(ss[j]);
            }
        }

        // turn
        int k = Integer.parseInt(st.nextToken());
        firsts = new int[GN];

        for (int i = 0; i < k; i++) {
//            print();
            // BFS - 연쇄 회전

            Queue<Gear> que = new ArrayDeque<>();
            que.add(new Gear(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));

            boolean[] visit = new boolean[GN];

            while (!que.isEmpty()) {
                Gear gear = que.poll();
                int num = gear.num;
                int turn = gear.turn;

                if (visit[num]) continue;

                visit[num] = true;

                // 왼쪽 톱니바퀴의 오른쪽 톱니 확인
                if (gear.num - 1 >= 0 && !visit[gear.num - 1]) {
                    if (gears[num - 1][(firsts[num - 1] + 2) % TN] != gears[num][(firsts[num] + 6) % TN]) {
                        que.add(new Gear(num - 1, turn * -1));
                    }
                }

                // 오른쪽 톱니바퀴 확인
                if (gear.num + 1 < GN && !visit[gear.num + 1]) {
                    if (gears[num + 1][(firsts[num + 1] + 6) % TN] != gears[num][(firsts[num] + 2) % TN]) {
                        que.add(new Gear(num + 1, turn * -1));
                    }
                }
                if (turn == 1)
                    firsts[num] = (firsts[num] + 7) % TN;
                else
                    firsts[num] = (firsts[num] + 1) % TN;
            }
        }
//        print();

        // output
        int answer = 0;

        if (gears[0][firsts[0]] == 1) answer += 1;
        if (gears[1][firsts[1]] == 1) answer += 2;
        if (gears[2][firsts[2]] == 1) answer += 4;
        if (gears[3][firsts[3]] == 1) answer += 8;

        System.out.println(answer);
    }
    private static void print() {
        System.out.println("\n=======================================");
        for (int i = 0; i < GN; i++) {
            int k = firsts[i];
            for (int j = 0; j < TN; j++) {
                System.out.print(gears[i][k] + " ");
                k = (k+1)%TN;
            }
            System.out.println();
        }
    }

    private static class Gear {
        int num, turn;

        public Gear(int num, int turn) {
            this.num = num;
            this.turn = turn;
        }
    }

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new int[GN][TN];
        for (int i = 0; i < GN; i++) {
            String[] ss = br.readLine().split("");
            for (int j = 0; j < TN; j++) {
                gears[i][j] = Integer.parseInt(ss[j]);
            }
        }

        // turn
        int k = Integer.parseInt(br.readLine());
        firsts = new int[GN];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
//            print();
            // BFS - 연쇄 회전

            Queue<Gear> que = new ArrayDeque<>();
            que.add(new Gear(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));

            boolean[] visit = new boolean[GN];

            while (!que.isEmpty()) {
                Gear gear = que.poll();
                int num = gear.num;
                int turn = gear.turn;

                if (visit[num]) continue;

                visit[num] = true;

                // 왼쪽 톱니바퀴의 오른쪽 톱니 확인
                if (gear.num - 1 >= 0 && !visit[gear.num - 1]) {
                    if (gears[num - 1][(firsts[num - 1] + 2) % TN] != gears[num][(firsts[num] + 6) % TN]) {
                        que.add(new Gear(num - 1, turn * -1));
                    }
                }

                // 오른쪽 톱니바퀴 확인
                if (gear.num + 1 < GN && !visit[gear.num + 1]) {
                    if (gears[num + 1][(firsts[num + 1] + 6) % TN] != gears[num][(firsts[num] + 2) % TN]) {
                        que.add(new Gear(num + 1, turn * -1));
                    }
                }
                if (turn == 1)
                    firsts[num] = (firsts[num] + 7) % TN;
                else
                    firsts[num] = (firsts[num] + 1) % TN;
            }
        }
//        print();

        // output
        int answer = 0;

        if (gears[0][firsts[0]] == 1) answer += 1;
        if (gears[1][firsts[1]] == 1) answer += 2;
        if (gears[2][firsts[2]] == 1) answer += 4;
        if (gears[3][firsts[3]] == 1) answer += 8;

        System.out.println(answer);
    }
}
