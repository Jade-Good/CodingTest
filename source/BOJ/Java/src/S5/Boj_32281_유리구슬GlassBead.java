package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_32281_유리구슬GlassBead {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long result = 0;
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == '1') {
                cnt++;
            } else {
                result += cnt * (cnt + 1) / 2;
                cnt = 0;
            }
        }
        result += cnt * (cnt + 1) / 2;

        System.out.print(result);
    }
}





/*


      0   0   0   0   0
    0   0   0   1   0   0
  1   0   0   1   1   0   0
1   1   0   1   1   1   0   1

 */