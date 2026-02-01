package S2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class boj_2644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        int h1 = sc.nextInt();
        int h2 = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (!arr[x].contains(y)) {
                arr[x].add(y);
                arr[y].add(x);
            }
        }
        System.out.println(bfs(arr, h1, h2));
    }

    private static int bfs(ArrayList<Integer>[] arr, int h1, int h2) {
        boolean[] visit = new boolean[arr.length + 1];
        Stack<Person> stack = new Stack<>();
        stack.push(new Person(h1, 0));

        while (!stack.isEmpty()) {
            Person p = stack.pop();
            if (!visit[p.idx]) {
                if (p.idx == h2) {
                    return p.count;
                }

                visit[p.idx] = true;
                for (int i = 0; i < arr[p.idx].size(); i++) {
                    stack.push(new Person(arr[p.idx].get(i), p.count + 1));
                }
            }
        }
        return -1;
    }

    private static class Person {
        int idx;
        int count;

        Person(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }
}
