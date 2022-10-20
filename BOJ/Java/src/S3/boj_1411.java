package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String arr[] = new String[n];

        for (int i = 0; i < n; i++)
            arr[i] = br.readLine();

        int answer = 0;
        for (int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++){
                int chr[] = new int[27];
                int rev[] = new int[27];
                boolean flag = true;
                for (int k = 0; k < arr[i].length(); k++) {
                    int idx = arr[i].charAt(k) - 'a' + 1;
                    int temp = arr[j].charAt(k) - 'a' + 1;
                    if (chr[idx] == 0 && rev[temp] == 0) {
                        chr[idx] = temp;
                        rev[temp] = idx;
                    }
                    else if (chr[idx] != temp || rev[temp] != idx){
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }
        System.out.println(answer);
    }
}
