package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class boj_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lp = 0, rp = k - 1;
        int sum = 0;
        for (int i = lp; i <= rp; i++) {
            sum += arr[i];
        }

        int answer = sum;
        for (int i = 0; i < n - k; i++) {
            sum -= arr[lp++];
            sum += arr[++rp];
            if (sum > answer)
                answer = sum;
        }
        System.out.println(answer);
    }
}
