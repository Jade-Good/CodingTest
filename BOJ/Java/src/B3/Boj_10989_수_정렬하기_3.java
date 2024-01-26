package B3;

import java.io.*;

public class Boj_10989_수_정렬하기_3 {
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
        int[] result = new int[arr.length];
        int digit = 1;

        for (int i = 0; i < max; i++) {
            int[] cnt = new int[10];
            for (int j = 0; j < arr.length; j++) { // 해당 자릿수의 원소 카운트
                cnt[(arr[j] / digit) % 10]++;
            }

            for (int j = 1; j < 10; j++) { // 합배열로 만들기
                cnt[j] += cnt[j - 1];
            }

            for (int j = arr.length - 1; j >= 0; j--) {
                result[cnt[arr[j] / digit % 10]-- - 1] = arr[j];
            }

            for (int j = 0; j < arr.length; j++) {
                arr[j] = result[j];
            }
            digit *= 10;
        }
    }
}
