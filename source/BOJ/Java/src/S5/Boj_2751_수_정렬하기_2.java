package S5;

import java.io.*;

public class Boj_2751_수_정렬하기_2 {

    private static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void merge_sort(int start, int end) {
        if (end - start < 1) return;
        int mid = start + (end - start) / 2;
        merge_sort(start, mid);
        merge_sort(mid + 1, end);

        int tempIdx = 0;
        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp[tempIdx++] = arr[left++];
            } else {
                temp[tempIdx++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[tempIdx++] = arr[left++];
        }

        while (right <= end) {
            temp[tempIdx++] = arr[right++];
        }

        tempIdx = 0;
        for (int i = start; i <= end; i++) {
            arr[i] = temp[tempIdx++];
        }
    }
}
