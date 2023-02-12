package S1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj_1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] visit = new boolean[100_001];

        Queue<Subin> que = new ArrayDeque<>();
        Subin subin = new Subin(n, 0);

        que.add(subin);

        while (!que.isEmpty()) {
            if ((subin = que.poll()).x == k) {
                break;
            }

            visit[subin.x] = true;

            if (subin.x - 1 >= 0 && !visit[subin.x - 1]) {
                que.add(new Subin(subin.x - 1, subin.ct + 1));
            }
            if (subin.x + 1 <= 100_000 && !visit[subin.x + 1]) {
                que.add(new Subin(subin.x + 1, subin.ct + 1));
            }
            if (subin.x * 2 <= 100_000 && !visit[subin.x * 2]) {
                que.add(new Subin(subin.x * 2, subin.ct + 1));
            }
        }
        System.out.println(subin.ct);
    }

    private static class Subin {
        int x, ct;

        Subin(int x, int ct) {
            this.x = x;
            this.ct = ct;
        }
    }
}
