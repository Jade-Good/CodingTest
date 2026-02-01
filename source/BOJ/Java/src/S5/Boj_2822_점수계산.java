package S5;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Boj_2822_점수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[8][2];

        for (int i = 0; i < 8; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i + 1;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int sum = 0;
        int[] result = new int[5];

        for (int i = 0; i < 5; i++) {
            sum += arr[7 - i][0];
            result[i] = arr[7 - i][1];
        }

        Arrays.sort(result);
        sb.append(sum).append('\n');

        for (int i : result) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
