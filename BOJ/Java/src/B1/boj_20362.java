package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_20362 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        String[] arr = new String[n];
        String answer = "";
        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (s.equals(st.nextToken())) {
                answer = st.nextToken();
                for (int j = 0; j < i; j++) {
                    if (arr[j].equals(answer))
                        count++;
                }
                break;
            }
            else {
                arr[i] = st.nextToken();
            }
        }
        System.out.println(count);
    }
}
