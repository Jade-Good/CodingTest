package S2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_15663_N과_M9 {
    private static int N, M, selected[];
    private static boolean[] checked;
    private static ArrayList<Integer> nums;
    private static ArrayList<String> ans;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new ArrayList<>();
        selected = new int[M];
        checked = new boolean[N];
        ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(nums);

        // Permutation
        perm(0);

        // Output
        for (String s : ans) {
            sb.append(s).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);

            if (!ans.contains(sb.toString()))
                ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                selected[cnt] = nums.get(i);
                perm(cnt + 1);
                checked[i] = false;
            }
        }
    }
}
