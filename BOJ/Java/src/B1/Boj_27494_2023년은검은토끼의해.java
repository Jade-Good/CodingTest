package B1;

import java.io.*;

public class Boj_27494_2023년은검은토끼의해 {
    private static final char[] target = {'2', '0', '2', '3'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 2023; i <= n; i++) {
            if (find_2023(Integer.toString(i).toCharArray()))
                cnt++;
        }
        bw.write(Integer.toString(cnt));
        bw.flush();
    }

    private static boolean find_2023(char[] chars) {
        int idx = 0;
        for (char c : chars) {
            if (c == target[idx]) {
                idx++;
                if (idx == target.length) return true;
            }
        }
        return false;
    }
}
