package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11004_K번째 {
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N - 1, K - 1);
        bw.write(Integer.toString(A[K - 1]));
        bw.flush();
    }

    private static void quickSort(int start, int end, int K) {
        if (start < end) {
            int pivot = find_pivot(start, end);
            if (pivot == K) return;
            else if (pivot > K)
                quickSort(start, pivot - 1, K);
            else
                quickSort(pivot + 1, end, K);
        }
    }

    private static int find_pivot(int start, int end) {
        if (end - start == 1) {
            if (A[start] > A[end]) swap(start, end);
            return start;
        }

        int M = (start + end) / 2;

        swap(M, start);

        int pivot = A[start];
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (j > 0 && A[j] > pivot) j--;
            while (i < A.length - 1 && A[i] < pivot) i++;
            if (i <= j)
                swap(i++, j--);
        }

        A[start] = A[j];
        A[j] = pivot;
        return j;
    }

    private static void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
