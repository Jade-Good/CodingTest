package D0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ssafy_b_3_No1_새로운_불면증_치료법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            int count = 0;
            boolean[] visit = new boolean[10];
            int n = Integer.parseInt(br.readLine());
            int com = 1;

            while(count < 10) {
                int temp = n*com;
                while(temp > 0) {
                    int idx = temp%10;
                    if (!visit[idx]) {
                        visit[idx] = true;
                        count++;
                    }
                    temp /= 10;
                }
                com++;
            }
            com--;
            System.out.println("#" + t + " " + n*com);
        }
    }
}
