package P5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1517_버블_소트 {

    private static int[] arr, temp;
    private static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        merge_sort(0, N - 1);

        bw.write(Long.toString(result));
        bw.flush();
    }

    private static void merge_sort(int start, int end) {
        if (end - start < 1) return;

        int mid = start + (end - start) / 2;
        int tempIdx = start;
        int left = start;
        int right = mid + 1;

        merge_sort(left, mid);
        merge_sort(right, end);

        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[tempIdx++] = arr[left++];
            } else {
                temp[tempIdx++] = arr[right++];
                result += right - tempIdx;
            }
        }

        while (left <= mid) {
            temp[tempIdx++] = arr[left++];
        }
        while (right <= end) {
            temp[tempIdx++] = arr[right++];
        }

        tempIdx = start;
        
        for (int i = start; i <= end; i++) {
            arr[i] = temp[tempIdx++];
        }
    }
}
