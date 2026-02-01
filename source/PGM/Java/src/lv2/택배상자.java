package lv2;

import java.util.Stack;

public class 택배상자 {
    public int solution(int[] order) {

        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int answer = 0;

        for (int i = 1; i <= order.length; i++) { // 기존 컨테이너의 순서

            // 보조 컨테이너 확인
            while (!stack.empty() && idx < order.length && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            }

            // 기존 컨테이너 확인
            if (idx == order.length) {
                return answer;
            }

            if (order[idx] != i) { // 다름
                stack.push(i);
            } else { // 찾음
                answer++;
                idx++;
            }
        }

        // 보조 컨테이너 확인
        while (!stack.empty() && idx < order.length && stack.peek() == order[idx]) {
            stack.pop();
            idx++;
            answer++;
        }

        return answer;
    }
}
