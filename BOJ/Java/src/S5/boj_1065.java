package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i <= n; i++){
            String s[] = Integer.toString(i).split("");
            boolean flag = true;
            if (s.length > 1){
                int diff = Integer.parseInt(s[1]) - Integer.parseInt(s[0]);
                for (int j = 1; j < s.length-1; j++){
                    if (Integer.parseInt(s[j+1]) - Integer.parseInt(s[j]) != diff) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag)
                answer++;
        }
        System.out.println(answer);
    }
}
