package S4;

import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj_2164_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            que.add(i);
        }

        while (que.size() > 1) {
            que.poll();
            que.add(que.poll());
        }
        System.out.println(que.poll());
    }
}
