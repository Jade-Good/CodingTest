package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        int answer = 0;

        for (int i = 0; i <= b.length() - a.length(); i++){
            int count = 0;
            for (int j = 0; j < a.length(); j++){
                if (a.charAt(j) == b.charAt(i+j)) count++;
            }
            if (count > answer)
                answer = count;
        }
        System.out.println(a.length() - answer);
    }
}
