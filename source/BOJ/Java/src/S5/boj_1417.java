package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int mv = 0 ,mv_idx = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] >= mv) {
                mv = arr[i];
                mv_idx = i;
            }
        }

        int answer = 0;
        while (mv_idx > 0){
            arr[0]++;
            arr[mv_idx]--;
            answer++;
            mv = 0;
            mv_idx = 0;
            for (int i = 0; i < n; i++){
                if (arr[i] >= mv){
                    mv = arr[i];
                    mv_idx = i;
                }
            }
        }
        System.out.println(answer);
    }
}
