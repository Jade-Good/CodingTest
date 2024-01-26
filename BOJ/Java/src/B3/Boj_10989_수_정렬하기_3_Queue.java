package B3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj_10989_수_정렬하기_3_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        radix_sort(arr, 5);

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void radix_sort(int[] arr, int max) {
        for (int i = 1; i <= max; i++) {
            Queue<Integer>[] que = new Queue[10];
            for (int j = 0; j < 10; j++) {
                que[j] = new ArrayDeque<>();
            }

            for (int num : arr) {
                que[num / i % 10].add(num);
            }

            int idx = 0;
            for (int j = 0; j < 10; j++) {
                while (!que[j].isEmpty())
                    arr[idx++] = que[j].poll();
            }
        }
    }
}
