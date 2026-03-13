package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_3040_백설공주와일곱난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] nums = new int[9];
        int[] selectedIdx = new int[7];

        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        combination(0, 7, 0, 0, nums, selectedIdx);

        for (int i = 0; i < 7; i++) {
            sb.append(nums[selectedIdx[i]]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean combination(int cnt, int max, int sum, int start, int[] nums, int[] selectedIdx) {
        if (cnt == max) {
            return sum == 100;
        }

        for (int i = start; i < 9; i++) {
            if (sum + nums[i] <= 100) {
                selectedIdx[cnt] = i;
                if (combination(cnt + 1, max, sum + nums[i], i + 1, nums, selectedIdx)) {
                    return true;
                }
            }
        }

        return false;
    }
}
