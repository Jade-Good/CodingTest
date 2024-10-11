package S3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_25624_SNUPTI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        PriorityQueue<Character>[] order = new PriorityQueue[26];
        for (int i = 0; i < 26; i++) {
            order[i] = new PriorityQueue<>();
        }
        Map<String, Boolean> dict = new HashMap<>();
        String snupti;
        boolean able = true;

        int sz = scanner.nextInt();
        int tc = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        for (int k = 0; k < tc; k++) {
            snupti = scanner.nextLine();
            if (dict.containsKey(snupti)) {
                able = false;
            } else {
                dict.put(snupti, true);
            }
            if (!able) {
                continue;
            }
            for (int n = 0; n < sz; n++) {
                if (alphabet[snupti.charAt(n) - 'A'] == -1) {
                    alphabet[snupti.charAt(n) - 'A'] = n;
                    order[n].offer(snupti.charAt(n));
                } else if (alphabet[snupti.charAt(n) - 'A'] != n) {
                    able = false;
                }
            }
        }

        if (!able) {
            System.out.println("NO");
        } else {
            int sum = 1;
            for (int n = 0; n < sz; n++) {
                sum *= order[n].size();
            }
            if (sum != tc) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                for (int n = 0; n < sz; n++) {
                    while (!order[n].isEmpty()) {
                        System.out.print(order[n].poll());
                    }
                    System.out.println();
                }
            }
        }
        scanner.close();
    }
}
