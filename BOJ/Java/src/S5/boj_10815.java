package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int temp = 10000000;

        boolean check[] = new boolean[temp*2 + 1];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            check[temp + Integer.parseInt(st.nextToken())] = true;

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            if (check[temp + Integer.parseInt(st.nextToken())])
                System.out.print("1 ");
            else
                System.out.print("0 ");
        }
    }
}
