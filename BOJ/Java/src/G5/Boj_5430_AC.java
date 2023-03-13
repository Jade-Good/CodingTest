package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj_5430_AC {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] ss = str.substring(1, str.length() - 1).split(",");

            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(ss[i]));
            }

            // 중복 R 제거
            while (p.contains("RR")) {
                p = p.replace("RR", "");
            }

            // 연산 수행
            process(p, arr);
        }
    }

    private static void process(String p, ArrayList<Integer> arr) {
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == 'R') {
                Collections.reverse(arr);
            } else {
                if (arr.size() == 0) {
                    System.out.println("error");
                    return;
                }
                arr.remove(0);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i : arr) {
            sb.append(i).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        System.out.println(sb);
    }
}