package S1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Boj_1991_트리_순회 {
    private static Map<Character, char[]> map;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            map.put(chars[0], new char[]{chars[2], chars[4]});
        }
        prefix('A');
        sb.append('\n');
        infix('A');
        sb.append('\n');
        postfix('A');

        bw.write(sb.toString());
        bw.flush();
    }

    private static void prefix(char now) {
        sb.append(now);
        if (map.get(now)[0] != '.') prefix(map.get(now)[0]);
        if (map.get(now)[1] != '.') prefix(map.get(now)[1]);
    }

    private static void infix(char now) {
        if (map.get(now)[0] != '.') infix(map.get(now)[0]);
        sb.append(now);
        if (map.get(now)[1] != '.') infix(map.get(now)[1]);
    }

    private static void postfix(char now) {
        if (map.get(now)[0] != '.') postfix(map.get(now)[0]);
        if (map.get(now)[1] != '.') postfix(map.get(now)[1]);
        sb.append(now);
    }
}
