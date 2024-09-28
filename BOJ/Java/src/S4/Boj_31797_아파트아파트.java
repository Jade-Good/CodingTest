package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_31797_아파트아파트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()) - 1;
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[M * 2][2];
        int idx = 0;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[idx][0] = i;
            arr[idx++][1] = Integer.parseInt(st.nextToken());
            arr[idx][0] = i;
            arr[idx++][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

        bw.write(Integer.toString(arr[N % arr.length][0]));
        bw.flush();
    }
}