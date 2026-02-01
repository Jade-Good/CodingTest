package S2;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_15666_N과_M12 {
    private static int M;
    private static Set<String> set;
    private static int[] arr, select;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        set = new HashSet<>();
        select = new int[M];
        sb = new StringBuilder();

        recursion(0, 0);

        sb.deleteCharAt(sb.length() - 1);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void recursion(int start, int cnt) {
        if (cnt == M) {
            StringBuilder temp = new StringBuilder();
            for (int n : select) {
                temp.append(n).append(' ');
            }

            if (!set.contains(temp.toString())) {

                set.add(temp.toString());

                for (int n : select) {
                    sb.append(n).append(' ');
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append('\n');

            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            select[cnt] = arr[i];
            recursion(i, cnt + 1);
        }
    }
}
