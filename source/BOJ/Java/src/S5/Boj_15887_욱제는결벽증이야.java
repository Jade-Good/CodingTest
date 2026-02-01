package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_15887_욱제는결벽증이야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] temp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (arr[i] != i) {
                int targetIdx = findTarget(arr, i);
                rotation(arr, temp, i, targetIdx);
                sb.append('\n').append(i).append(' ').append(targetIdx);
                cnt++;
            }
        }

        bw.write(cnt + sb.toString());
        bw.flush();
    }

    private static void rotation(int[] arr, int[] temp, int left, int right) {
        for (int i = right; i >= left; i--) {
            temp[left + right - i] = arr[i];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    private static int findTarget(int[] arr, int i) {
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] == i) return j;
        }
        return -1;
    }
}
