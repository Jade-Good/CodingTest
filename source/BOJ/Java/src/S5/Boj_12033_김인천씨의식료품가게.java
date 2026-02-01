package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_12033_김인천씨의식료품가게 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> ans = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N * 2; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < N; i++) {
                int P = list.get(list.size() - 1);
                list.remove(list.indexOf(P - P / 4));
                list.remove(list.size() - 1);
                ans.add(P - P / 4);
            }

            ans.sort(Comparator.naturalOrder());

            sb.append("Case #").append(t).append(':');
            for (int a : ans) {
                sb.append(' ').append(a);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
