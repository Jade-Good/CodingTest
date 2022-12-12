package S3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class boj_15654 {
    static ArrayList<Integer> arr, pick;
    static int n, m;

    private static void dfs() {
        if (pick.size() == m) {
            for (int i : pick) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println("");
        }

        for (int i = 0; i < n; i++) {
            if (!pick.contains(i)) {
                pick.add(i);
                dfs();
                pick.remove(pick.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new ArrayList<>();
        pick = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        dfs();
    }
}
