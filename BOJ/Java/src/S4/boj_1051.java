package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][m];

        for (int i = 0; i < n; i++){
            String temp[] = br.readLine().split("");
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int answer = 0;
        int min = n < m ? n:m;
        for (int l = 1; l < min; l++){
            for (int i = 0; i < n-l; i++){
                for (int j = 0; j < m-l; j++){
                    if (l>answer && arr[i][j] == arr[i+l][j] && arr[i][j] == arr[i][j+l] && arr[i][j] == arr[i+l][j+l])
                        answer = l;
                }
            }
        }
        answer++;
        System.out.println(answer*answer);
    }
}
