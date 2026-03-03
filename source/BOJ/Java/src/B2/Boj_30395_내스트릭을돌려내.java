package B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_30395_내스트릭을돌려내 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int cnt = 0;
        boolean flag = false;

        while (st.hasMoreTokens()) {
            int p = Integer.parseInt(st.nextToken());
            if (p > 0) {
                cnt++;
                flag = false;
            } else if (flag) {
                max = Math.max(max, cnt);
                cnt = 0;
                flag = false;
            } else {
                flag = true;
            }
        }
        max = Math.max(max, cnt);
        System.out.print(max);
    }
}
