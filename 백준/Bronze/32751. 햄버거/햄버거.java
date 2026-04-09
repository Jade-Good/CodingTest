import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        char[] s = br.readLine().toCharArray();

        if (s[0] != 'a' || s[N - 1] != 'a') {
            System.out.print("No");
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (s[i] == s[i + 1]) {
                System.out.print("No");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            if (cnt[s[i] - 'a']-- == 0) {
                System.out.print("No");
                return;
            }
        }

        System.out.print("Yes");
    }
}
