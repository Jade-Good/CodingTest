package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_7662_이중_우선순위_큐_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        // TestCase
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // Input
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            int max, min;
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char order = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                // Orders
                if (order == 'I') { // Inque
                    treeMap.put(num, treeMap.getOrDefault(num,0)+1);
                } else {            // Deque
                    if (treeMap.isEmpty()) continue;
                    if (num == 1) {     // max deque
                        max = treeMap.lastEntry().getValue();
                        if (max == 1) {
                            treeMap.remove(treeMap.lastKey());
                        } else {
                            treeMap.put(treeMap.lastKey(), max-1);
                        }
                    } else {            // min deque
                        min = treeMap.firstEntry().getValue();
                        if (min == 1) {
                            treeMap.remove(treeMap.firstKey());
                        } else {
                            treeMap.put(treeMap.firstKey(), min-1);
                        }
                    }
                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(treeMap.lastKey()).append(' ').append(treeMap.firstKey()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
