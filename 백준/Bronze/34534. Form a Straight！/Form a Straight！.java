import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] used = new boolean[10];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            used[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i <= 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (!used[j + i]) {
                    cnt++;
                }
            }
            min = Math.min(min, cnt);
        }

        System.out.print(min);
    }
}
