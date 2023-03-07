package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1541_잃어버린_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split_minus = br.readLine().split("-");
        int ans = sum_str(split_minus[0]);
        for (int i = 1; i < split_minus.length; i++) {
            ans -= sum_str(split_minus[i]);
        }
        System.out.println(ans);
    }

    private static int sum_str(String s) {
        int result = 0;
        String[] split_plus = s.split("\\+");
        for (String str : split_plus) {
            result += Integer.parseInt(str);
        }
        return result;
    }
}
