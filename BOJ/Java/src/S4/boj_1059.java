package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 1001;
        int answer = 0;

        for (int i = 0; i < l; i++){
            int s = Integer.parseInt(st.nextToken());
            if (s==n){
                System.out.println(answer);
                System.exit(0);
            }
            else if (s < n && s >= a)
                a = s+1;
            else if (s > n && s <= b)
                b = s-1;
        }

        if (a == 0) a++;
        if (b == 1001) b--;
        if (a == b) System.out.println(answer);
        else {
            for (int i = a; i <= n; i++){
                for (int j = n; j <= b; j++)
                {
                    if (i != j)
                        answer++;
                }
            }
            System.out.println(answer);
        }
    }
}
