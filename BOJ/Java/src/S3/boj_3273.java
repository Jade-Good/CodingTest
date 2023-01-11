package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = 0;
        int p1 = 0, p2 = n-1;
        while (p1 != p2) {
            int sum = arr[p1] + arr[p2];
            if (sum == x) {
                p1++;
                answer++;
            } else if (sum < x) {
                p1++;
            } else {
                p2--;
            }

        }
        System.out.println(answer);
        br.close();
    }
}
