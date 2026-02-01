package B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_25205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char c = br.readLine().charAt(n-1);

        String ja = "qwertasdfgzxcv";
        int flag = 0;
        for (int i = 0; i < ja.length(); i++){
            if (ja.charAt(i) == c){
                flag = 1;
                break;
            }
        }

        System.out.println(flag);
    }
}
