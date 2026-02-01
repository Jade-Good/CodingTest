package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        int answer = 0;
        for (int k = 0; k < n; k++){ // arr[k]가 좋은 수인지 확인
            long find = arr[k];
            int i = 0;
            int j = n - 1;
            while(i < j){   // 투 포인터
                if (arr[i] + arr[j] == find){
                    if (i != k && j != k){ // 자기 자신은 제외하고 서로 다른 수여야 함(위치만 달라도 됨)
                        answer++;
                        break;
                    } else if (i == k) i++;
                    else if (j == k) j--;
                } else if (arr[i] + arr[j] < find) i++;
                else j--;
            }
        }
        System.out.println(answer);
        br.close();
    }
}