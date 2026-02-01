package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int answer = 1;
        int start = 1;
        int end = 1;
        long sum = 1;

        while (end < n){
            if (sum == n){
                answer++;
                sum += ++end;
            } else if (sum > n) {
                sum -= start++;
            } else if (sum < n) {
                sum += ++end;
            }
        }
        System.out.println(answer);
    }
}
