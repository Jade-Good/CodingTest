package S3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class boj_15652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        while (!stack.isEmpty()) {
            if (stack.size() == m) {
                for (int i : stack) {
                    System.out.print(i + " ");
                }
                System.out.println("");

                while (!stack.isEmpty()) {
                    int temp = stack.pop();
                    if (temp + 1 <= n) {
                        stack.push(temp + 1);
                        break;
                    }
                }
            }
            else stack.push(stack.peek());
        }
    }
}
