package S4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1920_수_찾기 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        //Sort
        Arrays.sort(arr);

        // Binary Search
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N - 1;

            while(start <= end) {
                int mid = (start+end) / 2;
                int mv = arr[mid];
                if (mv > target) end = mid-1;
                else if (mv < target) start = mid+1;
                else {
                    find = true;
                    break;
                }
            }
            sb.append(find?1:0).append('\n');
        }

        // Output
        bw.write(sb.toString());
        bw.flush();
    }

}
