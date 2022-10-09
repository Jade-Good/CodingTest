package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2714 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            String answer = "";
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            String msg = st.nextToken();

            String arr[] = new String[r];
            for (int j = 0; j < r; j++) {
                arr[j] = msg.substring(c * j, c * j + c);
            }

            int len = r*c/5;
            String matrix[] = new String[len];
            for (int j = 0; j < len; j++)
                matrix[j] = "";

            int x=0, y=0, flag = 1, count = 0, idx = 0, mc = c, mr = r;
            while (idx < len){
                for (int cc = 0; cc < mc; cc++){
                    matrix[idx] += arr[x].charAt(y);
                    y += flag;
                    if (++count == 5){
                        idx++;
                        count = 0;
                        if (idx >= len) break;
                    }
                }
                if (idx >= len) break;
                y += flag*-1;
                x += flag;
                mc--;
                for (int rr = 0; rr < mr-1; rr++){
                    matrix[idx] += arr[x].charAt(y);
                    x += flag;
                    if (++count == 5){
                        idx++;
                        count = 0;
                        if (idx >= len) break;
                    }
                }
                mr--;
                x += flag*-1;
                flag *= -1;
                y += flag;
            }
            for (int j = 0; j < len; j++) {
                int temp = 0;
                int num = 0;
                for (int k = 4; k >= 0; k--){
                    temp += (matrix[j].charAt(k) - '0') * Math.pow(2, num++);
                }
                if (temp == 0) answer += " ";
                else answer += (char) ('A' + temp - 1);
            }
            System.out.println(answer.stripTrailing());
        }
    }
}
