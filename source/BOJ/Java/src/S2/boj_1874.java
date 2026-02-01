package S2;

import java.io.*;
import java.util.Stack;

public class boj_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        for (int i = 0; i < n; i++){
            int su = Integer.parseInt(br.readLine());
            if (su >= num){
                while (su >= num){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else {
                int pop = stack.pop();

                if (pop > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    sb.append("-\n");
                }
            }
        }
        if (result) System.out.println(sb.toString());
    }
}
